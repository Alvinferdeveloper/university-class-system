package com.albin.universitySystem.DTOs.Response;

import com.albin.universitySystem.entities.Authority;
import com.albin.universitySystem.entities.Profesor;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Builder
@Data
public class RoleResponse {
    private Long id;
    private String name;
}
