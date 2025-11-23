package com.hw1.order.application;

import com.hw1.common.ResponseEntity;
import com.hw1.order.application.dto.OrderCommand;
import com.hw1.order.application.dto.OrderInfo;
import com.hw1.order.domain.OrderRepository;
import com.hw1.order.domain.PurchaseOrder;
import com.hw1.order.domain.PurchaseOrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public ResponseEntity<OrderInfo> create(OrderCommand command) {
        PurchaseOrder order = PurchaseOrder.create(
                command.productId(),
                command.sellerId(),
                command.memberId(),
                command.amount(),
                command.status()
        );
        PurchaseOrder saved = orderRepository.save(order);
        return new ResponseEntity<>(HttpStatus.OK.value(), OrderInfo.from(saved), 1);
    }

    public ResponseEntity<List<OrderInfo>> findAll(Pageable pageable) {
        Page<PurchaseOrder> purchaseOrderPage = orderRepository.findAll(pageable);
        List<OrderInfo> contents = purchaseOrderPage
                .stream()
                .map(OrderInfo::from)
                .toList();

        return new ResponseEntity<>(
                HttpStatus.OK.value(),
                contents,
                purchaseOrderPage.getTotalElements()
        );
    }

    public ResponseEntity<OrderInfo> statusChange(String id, PurchaseOrderStatus status) {
        PurchaseOrder order = orderRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("order not found id : " + id));

        order.updateStatus(status);
        PurchaseOrder saved = orderRepository.save(order);

        return new ResponseEntity<>(HttpStatus.OK.value(), OrderInfo.from(saved), 1);
    }
}