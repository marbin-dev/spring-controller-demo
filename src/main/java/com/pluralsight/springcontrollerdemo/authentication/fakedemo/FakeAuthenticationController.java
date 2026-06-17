package com.pluralsight.springcontrollerdemo.authentication.fakedemo;

import com.pluralsight.springcontrollerdemo.authentication.dto.fakedemo.SimpleLoginRequest;
import com.pluralsight.springcontrollerdemo.authentication.dto.fakedemo.SimpleLoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/auth")

public class FakeAuthenticationController {

    @PostMapping("/login")

    public SimpleLoginResponse login(@RequestBody SimpleLoginRequest request) {

        return new SimpleLoginResponse("fake.jwt.token");

    }

}
