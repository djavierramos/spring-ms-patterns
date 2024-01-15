package com.breadhard.spring.patterns.ordersservice.infraestructure.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetOrderByIdResponseDTO {
    private String id;
    private String customerId;
}
