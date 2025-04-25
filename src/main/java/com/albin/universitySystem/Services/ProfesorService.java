package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.ProfesorRequestDTO;
import com.albin.universitySystem.DTOs.Response.ProfesorResponseDTO;
import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.Repositories.ProfesorRepository;
import com.albin.universitySystem.utils.mappers.ProfesorMapper;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService implements ICrud<ProfesorRequestDTO, ProfesorResponseDTO> {

    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    public ProfesorService(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    @Override
    @Transactional
    public ProfesorResponseDTO insert(ProfesorRequestDTO profesorRequest) {
        if(profesorRepository.existsByEmail(profesorRequest.getEmail())){
            throw new EntityExistsException("Email already exists: " + profesorRequest.getEmail());
        }
        Profesor profesor = profesorMapper.dtoToEntity(profesorRequest);
        profesor = profesorRepository.save(profesor);
        return profesorMapper.entityToDto(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public ProfesorResponseDTO findById(long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor not found with id: " + id));
        return profesorMapper.entityToDto(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorResponseDTO> findAll() {
        return profesorRepository.findAll().stream()
                .map(profesorMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProfesorResponseDTO update(Long id, ProfesorRequestDTO profesorRequest) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor not found with id: " + id));
        Profesor updatedProfesor = profesorMapper.dtoToEntity(profesorRequest);
        updatedProfesor.setId(profesor.getId());
        updatedProfesor = profesorRepository.save(updatedProfesor);
        return profesorMapper.entityToDto(updatedProfesor);
    }

    @Override
    @Transactional
    public void delete(long id) {
        if (!profesorRepository.existsById(id)) {
            throw new EntityNotFoundException("Profesor not found with id: " + id);
        }
        profesorRepository.deleteById(id);
    }
}
