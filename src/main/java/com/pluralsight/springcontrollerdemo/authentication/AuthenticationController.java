package com.pluralsight.springcontrollerdemo.authentication;


import com.pluralsight.springcontrollerdemo.authentication.dto.LoginDto;
import com.pluralsight.springcontrollerdemo.authentication.dto.LoginResponseDto;
import com.pluralsight.springcontrollerdemo.authentication.dto.RegisterUserDto;
import com.pluralsight.springcontrollerdemo.authentication.models.Profile;
import com.pluralsight.springcontrollerdemo.authentication.models.User;
import com.pluralsight.springcontrollerdemo.authentication.security.jwt.JWTFilter;
import com.pluralsight.springcontrollerdemo.authentication.security.jwt.TokenProvider;
import com.pluralsight.springcontrollerdemo.authentication.service.ProfileService;
import com.pluralsight.springcontrollerdemo.authentication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@PreAuthorize("permitAll()")
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private UserService userService;
    private ProfileService profileService;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManager authenticationManager, UserService userService, ProfileService profileService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.profileService = profileService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);

        try
        {
            User user = userService.getByUserName(loginDto.getUsername());

            if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterUserDto newUser) {

        try
        {
            boolean exists = userService.exists(newUser.getUsername());
            if (exists)
            {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists.");
            }

            // create user
            User user = userService.create(new User(0, newUser.getUsername(), newUser.getPassword(), newUser.getRole()));

            // create profile
            Profile profile = new Profile();
            profile.setUserId(user.getId());
            profileService.create(profile);

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

}
