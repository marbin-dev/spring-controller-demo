package com.pluralsight.springcontrollerdemo.authentication.fakedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoAuthController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Anyone can see this";
    }

    @GetMapping("/private")
    public String privateEndpoint(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader == null) {
            return "No token was provided";
        }

        return "You sent this header: " + authorizationHeader;
    }
}