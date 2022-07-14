package com.example.uprise_submission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class WalletData {

    String coin;

    String address;

    BigDecimal amount;

}


