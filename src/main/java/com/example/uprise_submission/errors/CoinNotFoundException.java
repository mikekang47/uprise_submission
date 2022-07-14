package com.example.uprise_submission.errors;

public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException() {
        super("Coin Not Exists");
    }
}
