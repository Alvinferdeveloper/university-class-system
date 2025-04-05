package com.albin.universitySystem.DTOs.Request;

import com.albin.universitySystem.Enums.Semester;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequestDTO {
    @NotNull
    private Long profesorId;
    @NotNull
    private Long componenteId;
    @NotNull
    private Semester semester;
    @NotNull
    private Integer year;
}
