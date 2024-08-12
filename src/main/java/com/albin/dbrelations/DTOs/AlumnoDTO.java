package com.albin.dbrelations.DTOs;

import com.albin.dbrelations.Entitites.Componente;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
    List<ComponenteDTO> componentes ;
}
