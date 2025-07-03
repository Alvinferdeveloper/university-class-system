package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.AlumnoRequest;
import com.albin.universitySystem.DTOs.Response.AlumnoResponse;
import com.albin.universitySystem.entities.Alumno;
import com.albin.universitySystem.entities.Carrera;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.utils.IMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AlumnoMapper implements IMapper<AlumnoRequest, Alumno, AlumnoResponse> {
    CarreraMapper carreraMapper;
    CarreraRepository carreraRepository;
    public AlumnoMapper(CarreraMapper carreraMapper, CarreraRepository carreraRepository) {
        this.carreraMapper = carreraMapper;
        this.carreraRepository = carreraRepository;
    }
    @Override
    public  Alumno dtoToEntity(AlumnoRequest alumnoDTO) {
        Carrera carrera = carreraRepository.findById(alumnoDTO.getCarreraId()).orElseThrow(()->new EntityNotFoundException("Carrera not found"));
        return Alumno.builder()
                .name(alumnoDTO.getName())
                .lastName(alumnoDTO.getLastName())
                .email(alumnoDTO.getEmail())
                .phone(alumnoDTO.getPhone())
                .birthDate(alumnoDTO.getBirthDay())
                .dni(alumnoDTO.getDni())
                .carrera(carrera)
                .build();
    }
    @Override
    public AlumnoResponse entityToDto(Alumno alumno) {

        return AlumnoResponse.builder()
                .id(alumno.getId())
                .birthDay(alumno.getBirthDate())
                .name(alumno.getName())
                .lastName(alumno.getLastName())
                .phone(alumno.getPhone())
                .email(alumno.getEmail())
                .dni(alumno.getDni())
                .carrera(carreraMapper.entityToDto(alumno.getCarrera()))
                .build();
    }
}
