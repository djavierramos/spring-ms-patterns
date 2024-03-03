package com.breadhard.spring.patterns.customersservice.rest.controller;

import com.breadhard.spring.patterns.customersservice.application.domain.Customer;
import com.breadhard.spring.patterns.customersservice.application.queries.CustomerQueries;
import com.breadhard.spring.patterns.customersservice.application.queries.CustomersQueriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class CustomersController {
    @Autowired
    CustomerQueries customerQueries;

    @GetMapping("/{customer-id}")
    Mono<ResponseEntity> getCustomer(@PathVariable("customer-id") String customerId) {
        log.info(String.format("Get the customer %s", customerId));
        Optional<Customer> customer = customerQueries.getCustomerById(customerId);
        if (customer.isEmpty()) {
            log.info("Customer {} not found", customerId);
            return Mono.just(ResponseEntity.noContent().build());
        } else {
            log.info("Customer {} found", customerId);
            return Mono.just(ResponseEntity.ok().body(customer.get()));
        }
    }
}
