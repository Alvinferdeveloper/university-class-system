package com.albin.universitySystem.DTOs.Request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleRequest {
    @NotNull
    private Long id;
    @NotNull
    private String name;
}
