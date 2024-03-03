package com.breadhard.spring.patterns.customersservice.repository;

import com.breadhard.spring.patterns.customersservice.application.domain.Customer;

import java.util.Optional;

public interface CustomersRepository {
    Optional<Customer> getCustomerById(String customerId);
}
