package com.albin.universitySystem.utils.mappers;
import com.albin.universitySystem.DTOs.Request.RoleRequestDTO;
import com.albin.universitySystem.DTOs.Response.RoleResponseDTO;
import com.albin.universitySystem.Entitites.Role;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements IMapper<RoleRequestDTO, Role, RoleResponseDTO> {

    @Override
    public Role dtoToEntity(RoleRequestDTO dto) {
        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public RoleResponseDTO entityToDto(Role entity) {
        return RoleResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
