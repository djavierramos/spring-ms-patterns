package com.breadhard.spring.patterns.customersservice.application.queries;

import com.breadhard.spring.patterns.customersservice.application.domain.Customer;
import com.breadhard.spring.patterns.customersservice.repository.jdbc.adapter.CustomersJdbcRepositoryAdapter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@Slf4j
public class CustomersQueriesService implements CustomerQueries {
    @Autowired
    CustomersJdbcRepositoryAdapter customersJdbcRepositoryAdapter;

    public Optional<Customer> getCustomerById(String id) {
        return customersJdbcRepositoryAdapter.getCustomerById(id);
    }
}
