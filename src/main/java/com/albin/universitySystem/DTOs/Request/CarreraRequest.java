package com.albin.universitySystem.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarreraRequest {
    @NotNull
    String name;
    @NotNull
    Integer total_years;
}
