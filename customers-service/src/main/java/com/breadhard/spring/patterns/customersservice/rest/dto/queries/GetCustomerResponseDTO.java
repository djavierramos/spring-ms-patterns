package com.breadhard.spring.patterns.customersservice.rest.dto.queries;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@Jacksonized
public class GetCustomerResponseDTO {
    private String id;
    private String name;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:MM:ss:SSSz")
    private LocalDateTime lastModifiedDate;
}
