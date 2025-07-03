package com.albin.universitySystem.DTOs.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarreraResponse {
    long id;
    String name;
    int total_years;
}
