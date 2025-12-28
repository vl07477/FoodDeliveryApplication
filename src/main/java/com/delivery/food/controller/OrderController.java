package com.delivery.food.controller;

import com.delivery.food.dto.request.CreateOrderRequest;
import com.delivery.food.dto.request.UpdateOrderStatusRequest;
import com.delivery.food.dto.response.OrderResponse;
import com.delivery.food.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        // Получить customerId из SecurityContext
        Long customerId = 1L; // TODO: из токена
        return ResponseEntity.ok(orderService.createOrder(request, customerId));
    }
}
