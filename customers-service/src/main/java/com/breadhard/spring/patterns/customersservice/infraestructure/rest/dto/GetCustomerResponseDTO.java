package com.breadhard.spring.patterns.customersservice.infraestructure.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCustomerResponseDTO {
    private String id;
    private String name;
}
