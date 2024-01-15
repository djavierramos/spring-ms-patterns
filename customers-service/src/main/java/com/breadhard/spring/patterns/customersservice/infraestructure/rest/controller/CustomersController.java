package com.breadhard.spring.patterns.customersservice.infraestructure.rest.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breadhard.spring.patterns.customersservice.infraestructure.rest.dto.GetCustomerResponseDTO;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
@CrossOrigin
@RequiredArgsConstructor
public class CustomersController {
    @GetMapping("/{customer-id}")
    Mono<GetCustomerResponseDTO> getCustomer(@PathVariable("customer-id") String customerId) {
        return Mono.just(GetCustomerResponseDTO.builder().id(UUID.randomUUID().toString()).name("John Doe").build());
    }
}
