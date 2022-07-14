package com.example.uprise_submission.errors;

public class ExchangeNotFoundException extends RuntimeException {
    public ExchangeNotFoundException() {
        super("Exchange Not Found");
    }
}
