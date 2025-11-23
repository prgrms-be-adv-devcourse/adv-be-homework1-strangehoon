package com.hw1.payment.infrastructure;

import com.hw1.payment.domain.PaymentFailure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentFailureJpaRepository extends JpaRepository<PaymentFailure, UUID> {
}