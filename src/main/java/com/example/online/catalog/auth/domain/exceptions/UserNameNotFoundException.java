package com.example.online.catalog.auth.domain.exceptions;

public class UserNameNotFoundException extends RuntimeException {

    public UserNameNotFoundException() {
        super("user-name-not-found");
    }
}
