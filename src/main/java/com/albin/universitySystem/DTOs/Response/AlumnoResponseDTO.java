package com.albin.universitySystem.DTOs.Response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class AlumnoResponseDTO {
    private long id;
    private Date birthDay;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String dni;
    private CarreraResponseDTO carrera;
}
