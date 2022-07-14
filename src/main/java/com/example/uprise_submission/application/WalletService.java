package com.example.uprise_submission.application;


import com.example.uprise_submission.domain.Wallet;
import com.example.uprise_submission.dto.WalletData;
import com.example.uprise_submission.errors.CoinNotFoundException;
import com.example.uprise_submission.errors.ExchangeNotFoundException;
import com.example.uprise_submission.errors.accountcreationError;
import com.example.uprise_submission.infra.WalletRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Locale;


@Service
public class WalletService {
    private final WalletRepository walletRepository;
    private WebClient webClient;
    private List<String> BINANCE_COINS = List.of("USDT");
    private List<String> UPBIT_COINS = List.of("BTC", "ETH");

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    public Wallet create(String exchange, String coin) {
        Wallet wallet;

        if(exchange.toUpperCase(Locale.ROOT).equals("BINANCE")) {
            if(!checkBINANCECoinExistence(coin)) {
                throw new CoinNotFoundException();
            }
            wallet = createBinanceAccount(coin);
        } else if(exchange.toUpperCase(Locale.ROOT).equals("UPBIT")) {
            wallet = createUpbitAccount(coin);
        } else {
            throw new ExchangeNotFoundException();
        }

        return null;
    }

    private Wallet createUpbitAccount(String coin) throws accountcreationError {
        Wallet wallet = new Wallet();
        Wallet source =  webClient.post()
                .uri("https://test-exchange.make.codes")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(wallet)
                .retrieve()
                .bodyToMono(Wallet.class)
                .block();
        if(source == null) {
            throw new accountcreationError();
        }
        return walletRepository.save(source);
    }

    private Wallet createBinanceAccount(String coin) {
        Wallet wallet = new Wallet();
        Wallet source = webClient.post()
                .uri("https://test-exchange.make.codes")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(wallet)
                .retrieve()
                .bodyToMono(Wallet.class)
                .block();
        
        return walletRepository.save(source);
    }

    private boolean checkBINANCECoinExistence(String coin) {
        return BINANCE_COINS.contains(coin);
    }

    private boolean checkUPBITCoinExistence(String coin) {
        return UPBIT_COINS.contains(coin);
    }

}
