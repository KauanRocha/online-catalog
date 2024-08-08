package com.example.online.catalog.sales.application.core.domain;

public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException() {
        super("problem-to-execute-the-payment");
    }
}
