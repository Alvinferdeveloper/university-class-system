package com.albin.dbrelations.DTOs;

import com.albin.dbrelations.Entitites.Alumno;
import com.albin.dbrelations.Entitites.Profesor;
import com.albin.dbrelations.Enums.Semester;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
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