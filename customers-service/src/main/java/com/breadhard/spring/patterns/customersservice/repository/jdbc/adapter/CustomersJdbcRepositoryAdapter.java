package com.breadhard.spring.patterns.customersservice.repository.jdbc.adapter;

import com.breadhard.spring.patterns.customersservice.application.domain.Customer;
import com.breadhard.spring.patterns.customersservice.repository.CustomersRepository;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@NoArgsConstructor
@Setter
public class CustomersJdbcRepositoryAdapter implements CustomersRepository {
    @Autowired
    CustomersJdbcRepository customersJdbcRepository;

    public Optional<Customer> getCustomerById(String customerId) {
        log.info("Get customer by id: {}", customerId);
        return Optional.of(new Customer());
    }
}
