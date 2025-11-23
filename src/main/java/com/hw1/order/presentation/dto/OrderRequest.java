package com.hw1.order.presentation.dto;

import com.hw1.order.application.dto.OrderCommand;
import com.hw1.order.domain.PurchaseOrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderRequest (
    String productId,
    String sellerId,
    String memberId,
    BigDecimal amount,
    PurchaseOrderStatus status
){
    public OrderCommand toCommand(){
        UUID product = productId != null ? UUID.fromString(productId) : null;
        UUID seller = sellerId != null ? UUID.fromString(sellerId) : null;
        UUID member = memberId != null ? UUID.fromString(memberId) : null;
        return new OrderCommand(product, seller, member, amount, status);
    }
}
