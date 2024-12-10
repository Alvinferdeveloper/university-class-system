package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.CarreraRequestDTO;
import com.albin.universitySystem.DTOs.Response.CarreraResponseDTO;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper implements IMapper<CarreraRequestDTO, Carrera, CarreraResponseDTO> {
    @Override
    public Carrera dtoToEntity(CarreraRequestDTO carreraRequest) {
        return Carrera.builder()
                .name(carreraRequest.getName())
                .total_years(carreraRequest.getTotal_years())
                .build();
    }

    @Override
    public CarreraResponseDTO entityToDto(Carrera carrera) {
        return CarreraResponseDTO.builder()
                .id(carrera.getId())
                .name(carrera.getName())
                .total_years(carrera.getTotal_years())
                .build();
    }
}
