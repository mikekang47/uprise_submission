package com.example.uprise_submission.infra;

import com.example.uprise_submission.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
