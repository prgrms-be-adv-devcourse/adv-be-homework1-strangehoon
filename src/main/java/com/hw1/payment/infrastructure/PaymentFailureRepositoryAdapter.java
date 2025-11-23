package com.hw1.payment.infrastructure;

import com.hw1.payment.domain.PaymentFailure;
import com.hw1.payment.domain.PaymentFailureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentFailureRepositoryAdapter implements PaymentFailureRepository {

    private final PaymentFailureJpaRepository repository;

    public PaymentFailureRepositoryAdapter(PaymentFailureJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentFailure save(PaymentFailure failure) {
        return repository.save(failure);
    }
}