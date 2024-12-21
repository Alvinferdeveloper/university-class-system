package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.CarreraRequestDTO;
import com.albin.universitySystem.DTOs.Response.CarreraResponseDTO;
import com.albin.universitySystem.Entitites.Carrera;
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
public class CarreraService implements   ICrud<CarreraRequestDTO, CarreraResponseDTO>{
    private final CarreraRepository carreraRepository;
    private final CarreraMapper carreraMapper;

    @Override
    public CarreraResponseDTO insert(CarreraRequestDTO carreraRequest) {
        Carrera carrera = carreraMapper.dtoToEntity(carreraRequest);
        Carrera carreraDoc = carreraRepository.save(carrera);
        return carreraMapper.entityToDto(carreraDoc);
    }

    @Override
    public CarreraResponseDTO update(CarreraRequestDTO carreraRequest) {
        Carrera carrera = carreraRepository.findById(carreraRequest.getId()).orElseThrow(()-> new EntityNotFoundException("Carrera not found"));
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
    public CarreraResponseDTO findById(long id) {
        Carrera carrera = carreraRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Carrera no encontrada"));
        return carreraMapper.entityToDto(carrera);
    }

    @Override
    public List<CarreraResponseDTO> findAll() {
        List<Carrera> carreras = carreraRepository.findAll();
        return carreras.stream().map(carreraMapper::entityToDto).toList();
    }
}
