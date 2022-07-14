package com.example.uprise_submission.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name ="Wallets")
public class Wallet extends BaseTimeEntity {
    @Column(name="id", nullable = false)
    @Id
    @GeneratedValue
    Integer id;

    @Column(name="user", nullable = false, columnDefinition = "VARCHAR(36)")
    String user;

    @Column(name="coin", nullable = false, columnDefinition = "VARCHAR(10)")
    String coin = "";

    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(100)")
    String address;

    @Column(name="amount", nullable = false, columnDefinition = "DECIMAL(20,8)")
    BigDecimal amount = BigDecimal.valueOf(0.00000000);

}

