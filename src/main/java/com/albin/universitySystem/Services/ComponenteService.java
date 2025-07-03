package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.ComponenteRequest;
import com.albin.universitySystem.DTOs.Response.ComponenteResponse;
import com.albin.universitySystem.entities.Carrera;
import com.albin.universitySystem.entities.Componente;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.Repositories.ComponenteRepository;
import com.albin.universitySystem.utils.mappers.ComponenteMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ComponenteService implements  ICrud<ComponenteRequest, ComponenteResponse>{
    private final ComponenteRepository componenteRepository;
    private final ComponenteMapper componenteMapper;
    private final CarreraRepository carreraRepository;
    @Override
    public ComponenteResponse insert(ComponenteRequest componenteRequest) {
        Componente componente = componenteMapper.dtoToEntity(componenteRequest);
        Carrera carrera = carreraRepository.findById(componenteRequest.getCarreraId()).orElseThrow(()-> new EntityNotFoundException("No se encontro la carrera"));
        componente.setCarrera(carrera);
        Componente componenteDoc = componenteRepository.save(componente);
        return componenteMapper.entityToDto(componenteDoc);
    }

    @Override
    public ComponenteResponse update(Long id, ComponenteRequest updateRequest) {
        Componente componente = componenteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro la componente"));
        componente.setOwner_year(updateRequest.getOwner_year());
        componente.setName(updateRequest.getName());
        componente.setSemester(updateRequest.getSemester());
        Carrera carrera = carreraRepository.findById(updateRequest.getCarreraId()).orElseThrow(() -> new EntityNotFoundException("No se encontro la carrera"));
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
    public ComponenteResponse findById(long id) {
        Componente componente = componenteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontro el componente"));
        return componenteMapper.entityToDto(componente);
    }

    @Override
    public List<ComponenteResponse> findAll() {
        List<Componente> componentes = componenteRepository.findAll();
        return componentes.stream()
                .map(componenteMapper::entityToDto)
                .toList();
    }
}
