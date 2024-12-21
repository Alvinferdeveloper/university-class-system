package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.ComponenteRequestDTO;
import com.albin.universitySystem.DTOs.GroupDTO;
import com.albin.universitySystem.DTOs.Response.ComponenteResponseDTO;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ComponenteMapper implements IMapper<ComponenteRequestDTO, Componente, ComponenteResponseDTO> {

    @Override
    public Componente dtoToEntity(ComponenteRequestDTO componenteDTO) {
        return Componente.builder()
                .name(componenteDTO.getName())
                .owner_year(componenteDTO.getOwner_year())
                .semester(componenteDTO.getSemester())
                .build();
    }

    @Override
    public ComponenteResponseDTO entityToDto(Componente componente) {
        return ComponenteResponseDTO.builder()
                .id(componente.getId())
                .semester(componente.getSemester())
                .owner_year(componente.getOwner_year())
                .name(componente.getName())
                .build();
    }
}
