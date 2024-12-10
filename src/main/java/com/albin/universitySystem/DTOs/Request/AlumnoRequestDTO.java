package com.albin.universitySystem.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Builder
@Setter
@Getter
public class AlumnoRequestDTO {
    private long id;
    private Date birthDay;
    @NotBlank(message = "El campo no puede ser nulo")
    private String name;
    @NotBlank(message = "El campo no puede ser nulo")
    private String lastName;
    private String email;
    private String phone;
    private String dni;
    @NotNull(message = "Debes proporcionar una carrers")
    private Long carreraId;
}
