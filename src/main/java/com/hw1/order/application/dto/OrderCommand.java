package com.hw1.order.application.dto;

import com.hw1.order.domain.PurchaseOrderStatus;
import java.math.BigDecimal;
import java.util.UUID;

public record OrderCommand (
    UUID productId,
    UUID sellerId,
    UUID memberId,
    BigDecimal amount,
    PurchaseOrderStatus status
){
}