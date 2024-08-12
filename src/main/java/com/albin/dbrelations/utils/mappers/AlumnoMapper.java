package com.albin.dbrelations.utils.mappers;

import com.albin.dbrelations.DTOs.AlumnoDTO;
import com.albin.dbrelations.DTOs.ComponenteDTO;
import com.albin.dbrelations.Entitites.Alumno;
import com.albin.dbrelations.Entitites.Componente;
import com.albin.dbrelations.utils.IMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlumnoMapper implements IMapper<AlumnoDTO, Alumno> {
    @Override
    public  Alumno dtoToEntity(AlumnoDTO alumnoDTO) {
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
    public AlumnoDTO entityToDto(Alumno alumno) {
        List<ComponenteDTO> componentes = new ArrayList<>(); ;
        if(alumno.getComponentes()!=null){
           componentes = alumno.getComponentes().stream().map(componente ->
                    ComponenteDTO.builder()
                            .id(componente.getId())
                            .name(componente.getName())
                            .year(componente.getYear())
                            .semester(componente.getSemester())
                            .build()
            ).toList();
        }

        return AlumnoDTO.builder()
                .id(alumno.getId())
                .birthDay(alumno.getBirthDate())
                .lastName(alumno.getLastName())
                .name(alumno.getName())
                .email(alumno.getEmail())
                .phone(alumno.getPhone())
                .dni(alumno.getDni())
                .componentes(componentes)
                .build();
    }
}
