package com.albin.universitySystem.Services;

import com.albin.universitySystem.DTOs.Request.GroupRequestDTO;
import com.albin.universitySystem.DTOs.Response.GroupResponseDTO;
import com.albin.universitySystem.Entitites.Componente;
import com.albin.universitySystem.Entitites.Group;
import com.albin.universitySystem.Entitites.Profesor;
import com.albin.universitySystem.Repositories.ComponenteRepository;
import com.albin.universitySystem.Repositories.GroupRepository;
import com.albin.universitySystem.Repositories.ProfesorRepository;
import com.albin.universitySystem.utils.mappers.GroupMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService implements ICrud<GroupRequestDTO, GroupResponseDTO> {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final ProfesorRepository profesorRepository;
    private final ComponenteRepository componenteRepository;

    public GroupService(GroupRepository groupRepository, GroupMapper groupMapper, ProfesorRepository profesorRepository, ComponenteRepository componenteRepository) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.profesorRepository = profesorRepository;
        this.componenteRepository = componenteRepository;
    }

    @Override
    @Transactional
    public GroupResponseDTO insert(GroupRequestDTO groupRequest) {
        Group group = groupMapper.dtoToEntity(groupRequest);
        return getGroupResponseDTO(groupRequest, group);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupResponseDTO findById(long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found with id: " + id));
        return groupMapper.entityToDto(group);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupResponseDTO> findAll() {
        return groupRepository.findAll().stream()
                .map(groupMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GroupResponseDTO update(Long id, GroupRequestDTO groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Group not found with id: " + id));
        return getGroupResponseDTO(groupRequest, group);
    }

    private GroupResponseDTO getGroupResponseDTO(GroupRequestDTO groupRequest, Group group) {
        Profesor profesor = profesorRepository.findById(groupRequest.getProfesorId()).orElseThrow(()-> new EntityNotFoundException("Profesor Not Found"));
        Componente componente = componenteRepository.findById(groupRequest.getComponenteId()).orElseThrow(()-> new EntityNotFoundException("Componente Not Found"));
        group.setProfesor(profesor);
        group.setComponente(componente);
        group.setYear(groupRequest.getYear());
        Group updatedGroup = groupRepository.save(group);
        return groupMapper.entityToDto(updatedGroup);
    }

    @Override
    @Transactional
    public void delete(long id) {
        if (!groupRepository.existsById(id)) {
            throw new EntityNotFoundException("Group not found with id: " + id);
        }
        groupRepository.deleteById(id);
    }
}
