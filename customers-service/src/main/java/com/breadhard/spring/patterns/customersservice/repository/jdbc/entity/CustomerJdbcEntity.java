package com.breadhard.spring.patterns.customersservice.repository.jdbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "CUSTOMERS")
@Data
public class CustomerJdbcEntity {
    @Id
    @UuidGenerator
    String id;
    @Column(name = "NAME", nullable = false)
    String name;
    @Column(name = "EMAIL", unique = true)
    String email;
    @Column(name = "BIRTH_DATE", nullable = false)
    LocalDate birthDate;
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    LocalDateTime lastModifiedDate;
}
