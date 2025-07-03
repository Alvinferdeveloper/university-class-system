package com.albin.universitySystem.Services;
import com.albin.universitySystem.DTOs.Request.GroupRequest;
import com.albin.universitySystem.DTOs.Response.GroupResponse;
import com.albin.universitySystem.entities.Componente;
import com.albin.universitySystem.entities.Group;
import com.albin.universitySystem.entities.Profesor;
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
public class GroupService implements ICrud<GroupRequest, GroupResponse> {

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
    public GroupResponse insert(GroupRequest groupRequest) {
        Group group = groupMapper.dtoToEntity(groupRequest);
        return getGroupResponse(groupRequest, group);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupResponse findById(long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found with id: " + id));
        return groupMapper.entityToDto(group);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupResponse> findAll() {
        return groupRepository.findAll().stream()
                .map(groupMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GroupResponse update(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Group not found with id: " + id));
        return getGroupResponse(groupRequest, group);
    }

    private GroupResponse getGroupResponse(GroupRequest groupRequest, Group group) {
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
