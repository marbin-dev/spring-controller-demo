package com.pluralsight.springcontrollerdemo.authentication;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @GetMapping("/jwt/private")
    public String privateEndpoint() {
        return "This is secret, only users should be able to see this.";
    }

    @GetMapping("/jwt/public")
    public String publicEndpoint(){
        return "Anyone can access this endpoint";
    }


}
