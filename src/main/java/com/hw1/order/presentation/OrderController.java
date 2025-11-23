package com.hw1.order.presentation;

import com.hw1.common.ResponseEntity;
import com.hw1.order.application.OrderService;
import com.hw1.order.application.dto.OrderInfo;
import com.hw1.order.domain.PurchaseOrderStatus;
import com.hw1.order.presentation.dto.OrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.v1}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "주문 생성", description = "상품과 구매자 정보를 바탕으로 주문을 생성한다.")
    @PostMapping
    public ResponseEntity<OrderInfo> create(@RequestBody OrderRequest request) {
        return orderService.create(request.toCommand());
    }

    @Operation(summary = "주문 목록 조회", description = "생성된 주문을 페이지 단위로 조회한다.")
    @GetMapping
    public ResponseEntity<List<OrderInfo>> findAll(Pageable pageable) {
        return orderService.findAll(pageable);
    }

    @Operation(summary = "주문 상태 결제 변경", description = "주문을 결제로 변경한다.")
    @PatchMapping("{id}/paid")
    public ResponseEntity<OrderInfo> paid(@PathVariable String id) {
        return orderService.statusChange(id, PurchaseOrderStatus.PAID);
    }

    @Operation(summary = "결제 취소", description = "주문의 상태를 취소한다.")
    @PatchMapping("{id}/canceled")
    public ResponseEntity<OrderInfo> canceled(@PathVariable String id) {
        return orderService.statusChange(id, PurchaseOrderStatus.CANCELLED);
    }
}