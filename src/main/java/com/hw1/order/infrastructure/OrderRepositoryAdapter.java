package com.hw1.order.infrastructure;

import com.hw1.order.domain.OrderRepository;
import com.hw1.order.domain.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public PurchaseOrder save(PurchaseOrder order) {
        return orderJpaRepository.save(order);
    }

    @Override
    public Page<PurchaseOrder> findAll(Pageable pageable) {
        return orderJpaRepository.findAll(pageable);
    }

    @Override
    public Optional<PurchaseOrder> findById(UUID uuid) {
        return orderJpaRepository.findById(uuid);
    }
}
