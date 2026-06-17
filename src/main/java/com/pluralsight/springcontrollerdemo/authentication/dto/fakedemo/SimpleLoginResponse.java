package com.pluralsight.springcontrollerdemo.authentication.dto;

public class Simple {
    private String token;

    public Simple(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
