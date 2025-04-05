package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.ProfesorRequestDTO;
import com.albin.universitySystem.DTOs.Response.ProfesorResponseDTO;
import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper implements IMapper<ProfesorRequestDTO, Profesor,  ProfesorResponseDTO> {
    
    @Override
    public Profesor dtoToEntity(ProfesorRequestDTO dto) {
        return Profesor.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .dni(dto.getDni())
                .birthDate(dto.getBirthDate())
                .autorities(dto.getAutorities())
                .role(dto.getRole())
                .carreras(dto.getCarreras())
                .groups(dto.getGroups())
                .build();
    }

    @Override
    public ProfesorResponseDTO entityToDto(Profesor entity) {
        return ProfesorResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .phone(entity.getPhone())
                .dni(entity.getDni())
                .birthDate(entity.getBirthDate())
                .autorities(entity.getAutorities())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }
}
