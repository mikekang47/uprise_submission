package com.example.uprise_submission.errors;

public class accountcreationError extends RuntimeException {
    public accountcreationError() {
        super("Can not create Account");
    }
}
