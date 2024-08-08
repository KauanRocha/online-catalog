package com.example.online.catalog.manager.common.exceptions;

public class BackOfficeException extends RuntimeException{

    public BackOfficeException() {
        super();
    }

    public BackOfficeException(String message) {
        super(message);
    }
}
