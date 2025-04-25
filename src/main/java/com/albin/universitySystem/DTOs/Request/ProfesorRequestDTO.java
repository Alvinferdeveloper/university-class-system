package com.albin.universitySystem.DTOs.Request;

import com.albin.universitySystem.Entitites.Autoritie;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Entitites.Group;
import com.albin.universitySystem.Entitites.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProfesorRequestDTO {
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @NotNull
    private String phone;
    @Past
    private Date birthDate;
    @NotNull
    private String dni;
    @NotNull
    Long roleId;
}
