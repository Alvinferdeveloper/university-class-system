package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.ProfesorRequest;
import com.albin.universitySystem.DTOs.Response.ProfesorResponse;
import com.albin.universitySystem.entities.Profesor;
import com.albin.universitySystem.entities.Role;
import com.albin.universitySystem.Repositories.RoleRepository;
import com.albin.universitySystem.utils.IMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfesorMapper implements IMapper<ProfesorRequest, Profesor, ProfesorResponse> {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public Profesor dtoToEntity(ProfesorRequest dto) {
        Role role = roleRepository.findById(dto.getRoleId()).orElseThrow(()-> new EntityNotFoundException("Role not found"));
        return Profesor.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .dni(dto.getDni())
                .birthDate(dto.getBirthDate())
                .role(role)
                .build();
    }

    @Override
    public ProfesorResponse entityToDto(Profesor entity) {
        return ProfesorResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .phone(entity.getPhone())
                .dni(entity.getDni())
                .birthDate(entity.getBirthDate())
                .email(entity.getEmail())
                .role(roleMapper.entityToDto(entity.getRole()))
                .build();
    }
}
