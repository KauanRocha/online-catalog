package com.example.online.catalog.backoffice.exceptions;

public class BackOfficeException extends RuntimeException{

    public BackOfficeException() {
        super();
    }

    public BackOfficeException(String message) {
        super(message);
    }
}
