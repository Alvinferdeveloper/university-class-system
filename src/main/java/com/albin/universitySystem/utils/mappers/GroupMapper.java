package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.GroupRequestDTO;
import com.albin.universitySystem.DTOs.Response.GroupResponseDTO;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.Entitites.Group;
import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements IMapper< GroupRequestDTO, Group, GroupResponseDTO> {
    
    private final ProfesorMapper profesorMapper;
    private final ComponenteMapper componenteMapper;

    public GroupMapper(ProfesorMapper profesorMapper, ComponenteMapper componenteMapper) {
        this.profesorMapper = profesorMapper;
        this.componenteMapper = componenteMapper;
    }

    @Override
    public Group dtoToEntity(GroupRequestDTO dto) {
        return Group
                .builder()
                .semester(dto.getSemester())
                .year(dto.getYear())
                .build();
    }

    @Override
    public GroupResponseDTO entityToDto(Group entity) {
        GroupResponseDTO dto = new GroupResponseDTO();
        dto.setId(entity.getId());
        dto.setProfesor(profesorMapper.entityToDto(entity.getProfesor()));
        dto.setComponente(componenteMapper.entityToDto(entity.getComponente()));
        dto.setSemester(entity.getSemester());
        dto.setYear(entity.getYear());
        return GroupResponseDTO
                .builder()
                .id(entity.getId())
                .profesor(profesorMapper.entityToDto(entity.getProfesor()))
                .componente(componenteMapper.entityToDto(entity.getComponente()))
                .semester(entity.getSemester())
                .year(entity.getYear())
                .build();
    }
}
