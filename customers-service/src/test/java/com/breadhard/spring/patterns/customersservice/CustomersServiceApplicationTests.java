package com.breadhard.spring.patterns.customersservice;

import com.breadhard.spring.patterns.customersservice.repository.jdbc.entity.CustomerJdbcEntity;
import com.breadhard.spring.patterns.customersservice.repository.jdbc.adapter.CustomersJdbcRepository;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
@SpringBootTest
@AutoConfigureWebTestClient
@AutoConfigureDataJpa
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
@ContextConfiguration(classes = {CustomersServiceApplication.class})
@Slf4j
class CustomersServiceApplicationTests {
    private static final EasyRandom EASY_RANDOM = new EasyRandom();
    private static final List<CustomerJdbcEntity> CUSTOMERS = EASY_RANDOM.objects(CustomerJdbcEntity.class,50).toList();
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    CustomersJdbcRepository customersJdbcRepository;
    @BeforeEach
    public void beforeEach() {
        customersJdbcRepository.saveAll(CUSTOMERS);
    }
    @Test
    void contextLoads() {
        log.info("Context loads");
    }
    @Test
    @SneakyThrows
    void testGetCustomerById() {
        webTestClient.get()
                .uri("/customers/{customer-id}", CUSTOMERS.get(0).getId())
//                .header("bearer-token", UUID.randomUUID().toString())
//                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus()
                .isOk();
    }
}
