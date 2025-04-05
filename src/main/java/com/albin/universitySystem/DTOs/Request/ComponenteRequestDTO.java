package com.albin.universitySystem.DTOs.Request;

import com.albin.universitySystem.DTOs.GroupDTO;
import com.albin.universitySystem.Enums.Semester;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComponenteRequestDTO {
    @NotNull
    private String name;
    @NotNull
    private Integer owner_year;
    @NotNull
    private Semester semester;
    @NotNull(message = "carrera can not be null")
    private Long carreraId;
}