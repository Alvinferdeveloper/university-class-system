package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.GroupRequest;
import com.albin.universitySystem.DTOs.Response.GroupResponse;
import com.albin.universitySystem.entities.Group;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements IMapper<GroupRequest, Group, GroupResponse> {
    
    private final ProfesorMapper profesorMapper;
    private final ComponenteMapper componenteMapper;

    public GroupMapper(ProfesorMapper profesorMapper, ComponenteMapper componenteMapper) {
        this.profesorMapper = profesorMapper;
        this.componenteMapper = componenteMapper;
    }

    @Override
    public Group dtoToEntity(GroupRequest dto) {
        return Group
                .builder()
                .semester(dto.getSemester())
                .year(dto.getYear())
                .build();
    }

    @Override
    public GroupResponse entityToDto(Group entity) {
        return GroupResponse
                .builder()
                .id(entity.getId())
                .profesor(profesorMapper.entityToDto(entity.getProfesor()))
                .componente(componenteMapper.entityToDto(entity.getComponente()))
                .semester(entity.getSemester())
                .year(entity.getYear())
                .build();
    }
}
