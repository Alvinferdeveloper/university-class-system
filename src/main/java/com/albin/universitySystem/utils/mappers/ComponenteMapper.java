package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.AlumnoDTO;
import com.albin.universitySystem.DTOs.ComponenteDTO;
import com.albin.universitySystem.DTOs.GroupDTO;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.Entitites.Group;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ComponenteMapper implements IMapper<ComponenteDTO, Componente> {

    @Override
    public Componente dtoToEntity(ComponenteDTO componenteDTO) {
        return Componente.builder()
                .name(componenteDTO.getName())
                .owner_year(componenteDTO.getOwner_year())
                .semester(componenteDTO.getSemester())
                .build();
    }

    @Override
    public ComponenteDTO entityToDto(Componente componente) {
        ArrayList<GroupDTO> groups =(ArrayList<GroupDTO>) componente.getGroups().stream().map(group -> GroupDTO.builder()
                .id(group.getId())
                .profesor(group.getProfesor())
                .componente(group.getComponente())
                .semester(group.getSemester())
                .build()
        ).toList();

        return ComponenteDTO.builder()
                .id(componente.getId())
                .semester(componente.getSemester())
                .owner_year(componente.getOwner_year())
                .name(componente.getName())
                .groups(groups)
                .build();
    }
}
