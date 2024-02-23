package com.breadhard.spring.patterns.ordersservice.infraestructure.rest.controller;

import com.breadhard.spring.patterns.ordersservice.infraestructure.rest.dto.GetOrderByIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrdersController {
    @GetMapping("/{order-id}")
    Mono<GetOrderByIdResponseDTO> getOrder(@PathVariable("order-id") String orderId) {
        return Mono.just(GetOrderByIdResponseDTO.builder().id(UUID.randomUUID().toString()).customerId(UUID.randomUUID().toString()).build());
    }
}
