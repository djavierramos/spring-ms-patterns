package com.breadhard.spring.patterns.customersservice.infraestructure.rest.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breadhard.spring.patterns.customersservice.infraestructure.rest.dto.GetCustomerResponseDTO;

import jakarta.websocket.server.PathParam;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
public class CustomersController {
    @GetMapping("/{customer-id}")
    Mono<GetCustomerResponseDTO> getCustomer(@PathParam("customer-id") String customerId) {
        return Mono.just(GetCustomerResponseDTO.builder().id(UUID.randomUUID().toString()).name("John Doe").build());
    }
}
