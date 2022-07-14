package com.example.uprise_submission.controller;

import com.example.uprise_submission.application.WalletService;
import com.example.uprise_submission.domain.Wallet;
import com.example.uprise_submission.dto.WalletData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("{exchange}/accounts/{coin}")
    public Wallet createAccont(@PathVariable String exchange, @PathVariable String coin) {
        return walletService.create(exchange, coin);
    }


    @PostMapping("/{exchange}/transfers/deposit")
    public Wallet deposit(@PathVariable String exchange, @RequestBody WalletData walletData) {
        return walletService.makeDeposit(exchange);
    }


}
