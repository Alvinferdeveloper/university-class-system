package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.ComponenteDTO;
import com.albin.universitySystem.DTOs.ProfesorDTO;
import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.utils.IMapper;

import java.util.ArrayList;

public class ProfesorMapper implements IMapper<ProfesorDTO, Profesor> {
    @Override
    public Profesor dtoToEntity(ProfesorDTO profesorDTO) {
        return Profesor.builder()
                .name(profesorDTO.getName())
                .lastName(profesorDTO.getLastName())
                .phone(profesorDTO.getPhone())
                .email(profesorDTO.getEmail())
                .dni(profesorDTO.getDni())
                .birthDate(profesorDTO.getBirthDate())
                .build();
    }

    @Override
    public ProfesorDTO entityToDto(Profesor profesor) {
        ArrayList<ComponenteDTO> componenteDTOS = (ArrayList<ComponenteDTO>) profesor.getComponentes().stream().map(componente ->
            ComponenteDTO.builder()
                    .id(componente.getId())
                    .name(componente.getName())
                    .profesor(componente.getProfesor())
                    .semester(componente.getSemester())
                    .year(componente.getYear())
                    .build()
        ).toList();
        return ProfesorDTO.builder()
                .id(profesor.getId())
                .name(profesor.getName())
                .lastName(profesor.getLastName())
                .phone(profesor.getPhone())
                .dni(profesor.getDni())
                .birthDate(profesor.getBirthDate())
                .email(profesor.getEmail())
                .componentes(componenteDTOS)
                .build();
    }
}
