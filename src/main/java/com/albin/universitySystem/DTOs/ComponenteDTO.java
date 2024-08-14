package com.albin.universitySystem.DTOs;

import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.Enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComponenteDTO {
    private long id;
    private String name;
    private int year;
    List<AlumnoDTO> alumnos;
    Profesor profesor;
    Semester semester;
}