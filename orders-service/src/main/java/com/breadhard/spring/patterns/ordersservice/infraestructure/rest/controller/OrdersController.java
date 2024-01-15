package com.breadhard.spring.patterns.ordersservice.infraestructure.rest.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breadhard.spring.patterns.ordersservice.infraestructure.rest.dto.GetOrderByIdResponseDTO;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

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
