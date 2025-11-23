package com.hw1.order.application.dto;

import com.hw1.order.domain.PurchaseOrder;
import com.hw1.order.domain.PurchaseOrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderInfo(
        UUID id,
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount,
        PurchaseOrderStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static OrderInfo from(PurchaseOrder order) {
        return new OrderInfo(
                order.getId(),
                order.getProductId(),
                order.getSellerId(),
                order.getMemberId(),
                order.getAmount(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}