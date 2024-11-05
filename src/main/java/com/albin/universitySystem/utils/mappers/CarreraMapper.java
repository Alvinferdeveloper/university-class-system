package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.CarreraDTO;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper implements IMapper<CarreraDTO, Carrera> {
    @Override
    public Carrera dtoToEntity(CarreraDTO dto) {
        return null;
    }

    @Override
    public CarreraDTO entityToDto(Carrera carrera) {
        return CarreraDTO.builder()
                .id(carrera.getId())
                .name(carrera.getName())
                .total_years(carrera.getTotal_years())
                .build();
    }
}
