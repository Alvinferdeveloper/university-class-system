package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.CarreraRequest;
import com.albin.universitySystem.DTOs.Response.CarreraResponse;
import com.albin.universitySystem.entities.Carrera;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.utils.mappers.CarreraMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarreraService implements   ICrud<CarreraRequest, CarreraResponse>{
    private final CarreraRepository carreraRepository;
    private final CarreraMapper carreraMapper;

    @Override
    public CarreraResponse insert(CarreraRequest carreraRequest) {
        Carrera carrera = carreraMapper.dtoToEntity(carreraRequest);
        Carrera carreraDoc = carreraRepository.save(carrera);
        return carreraMapper.entityToDto(carreraDoc);
    }

    @Override
    public CarreraResponse update(Long id, CarreraRequest carreraRequest) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Carrera not found"));
        carrera.setName(carreraRequest.getName());
        carrera.setTotal_years(carreraRequest.getTotal_years());
        Carrera carrerUpdated = carreraRepository.save(carrera);
        return carreraMapper.entityToDto(carrerUpdated);
    }

    @Override
    public void delete(long id) {
        boolean carreraExists = carreraRepository.existsById(id);
        if(!carreraExists){
            throw new EntityNotFoundException("Carrera not found");
        }
        carreraRepository.deleteById(id);
    }

    @Override
    public CarreraResponse findById(long id) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Carrera no encontrada"));
        return carreraMapper.entityToDto(carrera);
    }

    @Override
    public List<CarreraResponse> findAll() {
        List<Carrera> carreras = carreraRepository.findAll();
        return carreras.stream().map(carreraMapper::entityToDto).toList();
    }
}
