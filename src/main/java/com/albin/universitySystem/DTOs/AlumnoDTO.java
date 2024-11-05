package com.albin.universitySystem.DTOs;

import com.albin.universitySystem.Entitites.Carrera;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Setter
@Getter
public class AlumnoDTO {
    private long id;
    private Date birthDay;
    @NotBlank(message = "El campo no puede ser nulo")
    private String name;
    @NotBlank(message = "El campo no puede ser nulo")
    private String lastName;
    private String email;
    private String phone;
    private String dni;
    CarreraDTO carrera;
}
