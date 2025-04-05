package com.albin.universitySystem.DTOs.Response;

import com.albin.universitySystem.Enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupResponseDTO {
    private Long id;
    private ProfesorResponseDTO profesor;
    private ComponenteResponseDTO componente;
    private Semester semester;
    private Integer year;
}
