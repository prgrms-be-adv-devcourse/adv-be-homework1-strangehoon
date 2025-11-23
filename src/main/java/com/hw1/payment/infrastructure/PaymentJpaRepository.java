package com.hw1.payment.infrastructure;

import com.hw1.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PaymentJpaRepository extends JpaRepository<Payment, UUID> {
}
