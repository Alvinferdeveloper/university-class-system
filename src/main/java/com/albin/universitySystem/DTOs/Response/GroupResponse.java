package com.albin.universitySystem.DTOs.Response;

import com.albin.universitySystem.Enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponse {
    private long id;
    private ProfesorResponse profesor;
    private ComponenteResponse componente;
    private Semester semester;
    private Integer year;
}
