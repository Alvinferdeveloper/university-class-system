package com.albin.universitySystem.DTOs.Request;

import com.albin.universitySystem.Entitites.Autoritie;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Entitites.Group;
import com.albin.universitySystem.Entitites.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProfesorRequestDTO {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private String dni;
    List<Autoritie> autorities;
    Role role;
    List<Carrera> carreras;
    List<Group> groups;
}
