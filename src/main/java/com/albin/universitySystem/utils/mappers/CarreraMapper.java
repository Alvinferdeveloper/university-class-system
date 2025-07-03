package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.CarreraRequest;
import com.albin.universitySystem.DTOs.Response.CarreraResponse;
import com.albin.universitySystem.entities.Carrera;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper implements IMapper<CarreraRequest, Carrera, CarreraResponse> {
    @Override
    public Carrera dtoToEntity(CarreraRequest carreraRequest) {
        return Carrera.builder()
                .name(carreraRequest.getName())
                .total_years(carreraRequest.getTotal_years())
                .build();
    }

    @Override
    public CarreraResponse entityToDto(Carrera carrera) {
        return CarreraResponse.builder()
                .id(carrera.getId())
                .name(carrera.getName())
                .total_years(carrera.getTotal_years())
                .build();
    }
}
