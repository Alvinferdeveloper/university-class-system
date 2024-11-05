package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.AlumnoDTO;
import com.albin.universitySystem.Entitites.Alumno;
import com.albin.universitySystem.Repositories.AlumnoRepository;
import com.albin.universitySystem.utils.mappers.AlumnoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements ICrud<AlumnoDTO> {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    AlumnoMapper alumnoMapper;

    @Override
    public AlumnoDTO insert(AlumnoDTO alumno) {
        Alumno newAlumno = alumnoMapper.dtoToEntity(alumno);
        Alumno alumnoDoc = alumnoRepository.save(newAlumno);
        return alumnoMapper.entityToDto(alumnoDoc);
    }

    @Override
    public AlumnoDTO update(AlumnoDTO alumno) {
        Alumno alumnoOptional = alumnoRepository.findById(alumno.getId()).orElseThrow(()-> new EntityNotFoundException("Alumno no encontrado"));
        alumnoOptional.setName(alumno.getName());
        alumnoOptional.setEmail(alumno.getEmail());
        alumnoOptional.setLastName(alumno.getLastName());
        alumnoOptional.setPhone(alumno.getPhone());
        alumnoOptional.setDni(alumno.getDni());
        alumnoOptional.setBirthDate(alumno.getBirthDay());
        Alumno alumnoUpdated = alumnoRepository.save(alumnoOptional);
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
    public AlumnoDTO findById(long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Alumno no encontrado"));
        return alumnoMapper.entityToDto(alumno);
    }

    @Override
    public List<AlumnoDTO> findAll() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream().map(alumnoMapper::entityToDto).toList();
    }
}
