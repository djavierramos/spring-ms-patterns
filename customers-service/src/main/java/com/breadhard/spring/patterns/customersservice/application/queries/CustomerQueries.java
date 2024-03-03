package com.breadhard.spring.patterns.customersservice.application.queries;

import com.breadhard.spring.patterns.customersservice.application.domain.Customer;

import java.util.Optional;

public interface CustomerQueries {
    Optional<Customer> getCustomerById(String id);
}
