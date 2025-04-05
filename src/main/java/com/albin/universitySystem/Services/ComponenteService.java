package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.ComponenteRequestDTO;
import com.albin.universitySystem.DTOs.Response.ComponenteResponseDTO;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.Repositories.ComponenteRepository;
import com.albin.universitySystem.utils.mappers.ComponenteMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ComponenteService implements  ICrud<ComponenteRequestDTO, ComponenteResponseDTO>{
    private final ComponenteRepository componenteRepository;
    private final ComponenteMapper componenteMapper;
    private final CarreraRepository carreraRepository;
    @Override
    public ComponenteResponseDTO insert(ComponenteRequestDTO componenteRequest) {
        Componente componente = componenteMapper.dtoToEntity(componenteRequest);
        Carrera carrera = carreraRepository.findById(componenteRequest.getCarreraId()).orElseThrow(()-> new EntityNotFoundException("No se encontro la carrera"));
        componente.setCarrera(carrera);
        Componente componenteDoc = componenteRepository.save(componente);
        return componenteMapper.entityToDto(componenteDoc);
    }

    @Override
    public ComponenteResponseDTO update(Long id, ComponenteRequestDTO componenteRequest) {
        Componente componente = componenteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro la componente"));
        componente.setOwner_year(componenteRequest.getOwner_year());
        componente.setName(componenteRequest.getName());
        componente.setSemester(componenteRequest.getSemester());
        Carrera carrera = carreraRepository.findById(componenteRequest.getCarreraId()).orElseThrow(()-> new EntityNotFoundException("No se encontro la carrera"));
        componente.setCarrera(carrera);
        return componenteMapper.entityToDto(componenteRepository.save(componente));
    }

    @Override
    public void delete(long id) {
        Componente componente = componenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el componente"));
        componenteRepository.delete(componente);
    }

    @Override
    public ComponenteResponseDTO findById(long id) {
        Componente componente = componenteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro el componente"));
        return componenteMapper.entityToDto(componente);
    }

    @Override
    public List<ComponenteResponseDTO> findAll() {
        List<Componente> componentes = componenteRepository.findAll();
        return componentes.stream()
                .map(componenteMapper::entityToDto)
                .toList();
    }
}
