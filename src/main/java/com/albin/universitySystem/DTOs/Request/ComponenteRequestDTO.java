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
    private long id;
    @NotNull
    private String name;
    private int owner_year;
    Semester semester;
    @NotNull(message = "El id de la carrera no puede ser null")
    Long carreraId;
}