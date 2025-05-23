package com.albin.universitySystem.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarreraRequestDTO {
    @NotNull
    String name;
    @NotNull
    Integer total_years;
}
