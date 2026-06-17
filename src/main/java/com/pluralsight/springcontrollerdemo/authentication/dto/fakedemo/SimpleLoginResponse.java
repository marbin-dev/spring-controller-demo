package com.pluralsight.springcontrollerdemo.authentication.dto.fakedemo;

public class SimpleLoginResponse {
    private String token;

    public SimpleLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
