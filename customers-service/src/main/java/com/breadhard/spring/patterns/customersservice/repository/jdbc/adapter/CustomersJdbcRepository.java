package com.breadhard.spring.patterns.customersservice.repository.jdbc.adapter;

import com.breadhard.spring.patterns.customersservice.repository.jdbc.entity.CustomerJdbcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersJdbcRepository extends JpaRepository<CustomerJdbcEntity, String> {

}
