package com.albin.universitySystem.utils.mappers;
import com.albin.universitySystem.DTOs.Request.ComponenteRequest;
import com.albin.universitySystem.DTOs.Response.ComponenteResponse;
import com.albin.universitySystem.entities.Componente;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ComponenteMapper implements IMapper<ComponenteRequest, Componente, ComponenteResponse> {

    @Override
    public Componente dtoToEntity(ComponenteRequest componenteDTO) {
        return Componente.builder()
                .name(componenteDTO.getName())
                .owner_year(componenteDTO.getOwner_year())
                .semester(componenteDTO.getSemester())
                .build();
    }

    @Override
    public ComponenteResponse entityToDto(Componente componente) {
        return ComponenteResponse.builder()
                .id(componente.getId())
                .semester(componente.getSemester())
                .owner_year(componente.getOwner_year())
                .name(componente.getName())
                .build();
    }
}
