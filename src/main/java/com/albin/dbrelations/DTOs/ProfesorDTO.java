package com.albin.dbrelations.DTOs;

import com.albin.dbrelations.Enums.Autoritie;
import com.albin.dbrelations.Enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ProfesorDTO {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private String dni;
    Role role;
    Autoritie autoritites;
    List<ComponenteDTO> componentes;
}
