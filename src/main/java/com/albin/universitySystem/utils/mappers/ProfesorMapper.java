package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.ProfesorRequestDTO;
import com.albin.universitySystem.DTOs.Response.ProfesorResponseDTO;
import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.utils.IMapper;

public class ProfesorMapper implements IMapper<ProfesorRequestDTO, Profesor, ProfesorResponseDTO> {
    @Override
    public Profesor dtoToEntity(ProfesorRequestDTO profesorDTO) {
        return Profesor.builder()
                .name(profesorDTO.getName())
                .lastName(profesorDTO.getLastName())
                .phone(profesorDTO.getPhone())
                .email(profesorDTO.getEmail())
                .dni(profesorDTO.getDni())
                .birthDate(profesorDTO.getBirthDate())
                .autorities(profesorDTO.getAutorities())
                .role(profesorDTO.getRole())
                .build();
    }

    @Override
    public ProfesorResponseDTO entityToDto(Profesor profesor) {
        return ProfesorResponseDTO.builder()
                .id(profesor.getId())
                .name(profesor.getName())
                .lastName(profesor.getLastName())
                .phone(profesor.getPhone())
                .dni(profesor.getDni())
                .birthDate(profesor.getBirthDate())
                .autorities(profesor.getAutorities())
                .email(profesor.getEmail())
                .build();
    }
}
