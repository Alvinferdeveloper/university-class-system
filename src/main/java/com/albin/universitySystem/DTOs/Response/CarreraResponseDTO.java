package com.albin.universitySystem.DTOs.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarreraResponseDTO {
    long id;
    String name;
    int total_years;
}
