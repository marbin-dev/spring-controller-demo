package com.pluralsight.springcontrollerdemo.authentication.dto.fakedemo;

// TODO:
//public record LoginRequest(String email, String password) { }

public class SimpleLoginRequest {
    private final String email;
    private final String password;

    public SimpleLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters (accessors)

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

}
