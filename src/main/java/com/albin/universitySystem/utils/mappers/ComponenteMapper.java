package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.AlumnoDTO;
import com.albin.universitySystem.DTOs.ComponenteDTO;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ComponenteMapper implements IMapper<ComponenteDTO, Componente> {

    @Override
    public Componente dtoToEntity(ComponenteDTO componenteDTO) {
        return Componente.builder()
                .name(componenteDTO.getName())
                .year(componenteDTO.getYear())
                .semester(componenteDTO.getSemester())
                .build();
    }

    @Override
    public ComponenteDTO entityToDto(Componente componente) {
        ArrayList<AlumnoDTO> alumnos =(ArrayList<AlumnoDTO>) componente.getAlumnos().stream().map(alumno -> AlumnoDTO.builder()
                .id(alumno.getId())
                .name(alumno.getName())
                .lastName(alumno.getLastName())
                .phone(alumno.getPhone())
                .email(alumno.getEmail())
                .dni(alumno.getDni())
                .birthDay(alumno.getBirthDate())
                .build()
        ).toList();

        return ComponenteDTO.builder()
                .id(componente.getId())
                .semester(componente.getSemester())
                .year(componente.getYear())
                .profesor(componente.getProfesor())
                .name(componente.getName())
                .alumnos(alumnos)
                .build();
    }
}
