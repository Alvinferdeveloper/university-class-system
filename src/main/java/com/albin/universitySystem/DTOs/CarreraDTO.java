package com.albin.universitySystem.DTOs;

import com.albin.universitySystem.Entitites.Alumno;
import com.albin.universitySystem.Entitites.Profesor;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CarreraDTO {
    long id;
    String name;
    int total_years;

}
