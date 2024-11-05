package com.albin.universitySystem.DTOs;

import com.albin.universitySystem.Entitites.*;
import com.albin.universitySystem.Enums.Semester;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDTO {
    private long id;
    Profesor profesor;
    Componente componente;
    Semester semester;
}
