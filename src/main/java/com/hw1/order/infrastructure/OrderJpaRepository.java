package com.hw1.order.infrastructure;

import com.hw1.order.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<PurchaseOrder, UUID> {
}
