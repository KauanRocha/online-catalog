package com.example.online.catalog.backoffice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BackOfficeNotFoundException extends BackOfficeException{

    public BackOfficeNotFoundException() {
        super();
    }

    public BackOfficeNotFoundException(String message) {
        super(message);
    }
}
