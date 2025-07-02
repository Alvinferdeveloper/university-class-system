package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.AlumnoRequestDTO;
import com.albin.universitySystem.DTOs.Response.AlumnoResponseDTO;
import com.albin.universitySystem.Entitites.Alumno;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Repositories.AlumnoRepository;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.utils.IMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AlumnoMapper implements IMapper<AlumnoRequestDTO, Alumno, AlumnoResponseDTO> {
    CarreraMapper carreraMapper;
    CarreraRepository carreraRepository;
    public AlumnoMapper(CarreraMapper carreraMapper, CarreraRepository carreraRepository) {
        this.carreraMapper = carreraMapper;
        this.carreraRepository = carreraRepository;
    }
    @Override
    public  Alumno dtoToEntity(AlumnoRequestDTO alumnoDTO) {
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
    public AlumnoResponseDTO entityToDto(Alumno alumno) {

        return AlumnoResponseDTO.builder()
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
