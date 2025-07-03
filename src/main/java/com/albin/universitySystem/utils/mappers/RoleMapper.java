package com.albin.universitySystem.utils.mappers;
import com.albin.universitySystem.DTOs.Request.RoleRequest;
import com.albin.universitySystem.DTOs.Response.RoleResponse;
import com.albin.universitySystem.entities.Role;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements IMapper<RoleRequest, Role, RoleResponse> {

    @Override
    public Role dtoToEntity(RoleRequest dto) {
        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public RoleResponse entityToDto(Role entity) {
        return RoleResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
