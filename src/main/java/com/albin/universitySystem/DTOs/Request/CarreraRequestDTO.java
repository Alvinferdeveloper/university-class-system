package com.albin.universitySystem.DTOs.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarreraRequestDTO {
    long id;
    String name;
    int total_years;

}
