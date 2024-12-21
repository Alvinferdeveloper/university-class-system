package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.ComponenteRequestDTO;
import com.albin.universitySystem.DTOs.Response.ComponenteResponseDTO;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.Repositories.ComponenteRepository;
import com.albin.universitySystem.utils.mappers.ComponenteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ComponenteService implements  ICrud<ComponenteRequestDTO, ComponenteResponseDTO>{
    private final ComponenteRepository componenteRepository;
    private final ComponenteMapper componenteMapper;
    @Override
    public ComponenteResponseDTO insert(ComponenteRequestDTO componenteRequest) {
        Componente componente = componenteMapper.dtoToEntity(componenteRequest);
        Componente componenteDoc = componenteRepository.save(componente);
        return componenteMapper.entityToDto(componenteDoc);
    }

    @Override
    public ComponenteResponseDTO update(ComponenteRequestDTO obj) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public ComponenteResponseDTO findById(long id) {
        return null;
    }

    @Override
    public List<ComponenteResponseDTO> findAll() {
        return List.of();
    }
}
