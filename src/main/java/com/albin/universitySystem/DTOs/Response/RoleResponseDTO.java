package com.albin.universitySystem.DTOs.Response;

import com.albin.universitySystem.Entitites.Autoritie;
import com.albin.universitySystem.Entitites.Profesor;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Builder
@Data
public class RoleResponseDTO {
    private Long id;
    private String name;
}
