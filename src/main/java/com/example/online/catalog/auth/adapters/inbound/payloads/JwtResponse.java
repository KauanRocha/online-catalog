package com.example.online.catalog.auth.adapters.inbound.payloads;

public record JwtResponse(String token, String type, Integer id, String name, String email) {

    public JwtResponse(String accessToken, Integer id, String name, String email) {
        this(accessToken, "Bearer", id, name, email);
    }

    public String getAccessToken() {
        return token;
    }

    public String getTokenType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
