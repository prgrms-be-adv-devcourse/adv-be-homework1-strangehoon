package com.hw1.order.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    PurchaseOrder save(PurchaseOrder order);

    Page<PurchaseOrder> findAll(Pageable pageable);

    Optional<PurchaseOrder> findById(UUID uuid);
}
