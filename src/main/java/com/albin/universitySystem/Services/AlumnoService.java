package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.AlumnoRequest;
import com.albin.universitySystem.DTOs.Response.AlumnoResponse;
import com.albin.universitySystem.entities.Alumno;
import com.albin.universitySystem.Repositories.AlumnoRepository;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.utils.mappers.AlumnoMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService implements ICrud<AlumnoRequest,AlumnoResponse> {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;
    private final CarreraRepository carreraRepository;

    @Override
    public AlumnoResponse insert(AlumnoRequest alumno) {
        Alumno newAlumno = alumnoMapper.dtoToEntity(alumno);
        newAlumno = alumnoRepository.save(newAlumno);
        return alumnoMapper.entityToDto(newAlumno);
    }

    @Override
    public AlumnoResponse update(Long id, AlumnoRequest alumno) {
        Alumno alumnoDoc = alumnoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Alumno no encontrado"));
        Alumno alumnoUpdated = alumnoMapper.dtoToEntity(alumno);
        alumnoUpdated.setId(alumnoDoc.getId());
        alumnoUpdated = alumnoRepository.save(alumnoUpdated);
        return alumnoMapper.entityToDto(alumnoUpdated);
    }

    @Override
    public void delete(long id) {
        Boolean existAlumno= alumnoRepository.existsById(id);
        if(!existAlumno)
            throw new EntityNotFoundException("Alumno no encontrado");
        alumnoRepository.deleteById(id);
    }


    @Override
    public AlumnoResponse findById(long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Alumno no encontrado"));
        return alumnoMapper.entityToDto(alumno);
    }

    @Override
    public List<AlumnoResponse> findAll() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream().map(alumnoMapper::entityToDto).toList();
    }
}
