package com.albin.universitySystem.utils.mappers;

import com.albin.universitySystem.DTOs.Request.AlumnoRequestDTO;
import com.albin.universitySystem.DTOs.Response.AlumnoResponseDTO;
import com.albin.universitySystem.Entitites.Alumno;
import com.albin.universitySystem.utils.IMapper;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AlumnoMapper implements IMapper<AlumnoRequestDTO, Alumno, AlumnoResponseDTO> {
    CarreraMapper carreraMapper;
    public AlumnoMapper(CarreraMapper carreraMapper) {
        this.carreraMapper = carreraMapper;
    }
    @Override
    public  Alumno dtoToEntity(AlumnoRequestDTO alumnoDTO) {
        return Alumno.builder()
                .name(alumnoDTO.getName())
                .lastName(alumnoDTO.getLastName())
                .email(alumnoDTO.getEmail())
                .phone(alumnoDTO.getPhone())
                .birthDate(alumnoDTO.getBirthDay())
                .dni(alumnoDTO.getDni())
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
