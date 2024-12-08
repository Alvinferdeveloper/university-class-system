package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.AlumnoRequestDTO;
import com.albin.universitySystem.DTOs.Response.AlumnoResponseDTO;
import com.albin.universitySystem.Entitites.Alumno;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Repositories.AlumnoRepository;
import com.albin.universitySystem.Repositories.CarreraRepository;
import com.albin.universitySystem.utils.mappers.AlumnoMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService implements ICrud<AlumnoRequestDTO,AlumnoResponseDTO> {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;
    private final CarreraRepository carreraRepository;

    @Override
    public AlumnoResponseDTO insert(AlumnoRequestDTO alumno) {
        Alumno newAlumno = alumnoMapper.dtoToEntity(alumno);
        Carrera carrera = carreraRepository.findById(alumno.getCarrera_id()).orElseThrow(EntityNotFoundException::new);
        newAlumno.setCarrera(carrera);
        Alumno alumnoDoc = alumnoRepository.save(newAlumno);
        return alumnoMapper.entityToDto(alumnoDoc);
    }

    @Override
    public AlumnoResponseDTO update(AlumnoRequestDTO alumno) {
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
    public AlumnoResponseDTO findById(long id) {
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Alumno no encontrado"));
        return alumnoMapper.entityToDto(alumno);
    }

    @Override
    public List<AlumnoResponseDTO> findAll() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream().map(alumnoMapper::entityToDto).toList();
    }
}
