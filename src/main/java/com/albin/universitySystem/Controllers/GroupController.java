package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.GroupRequestDTO;
import com.albin.universitySystem.DTOs.Response.GroupResponseDTO;
import com.albin.universitySystem.Services.GroupService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/addGroup")
    public ResponseEntity<GroupResponseDTO> insertGroup(@Valid @RequestBody GroupRequestDTO group) {
        GroupResponseDTO newGroup = groupService.insert(group);
        return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
    }

    @GetMapping("getGroup/{id}")
    public ResponseEntity<GroupResponseDTO> getGroup(@PathVariable Long id) {
        GroupResponseDTO group = groupService.findById(id);
        return ResponseEntity.ok(group);
    }

    @GetMapping("getAllGroups")
    public ResponseEntity<List<GroupResponseDTO>> getAllGroups() {
        List<GroupResponseDTO> groups = groupService.findAll();
        return ResponseEntity.ok(groups);
    }

    @PutMapping("updateGroup/{id}")
    public ResponseEntity<GroupResponseDTO> updateGroup(
            @Valid @RequestBody GroupRequestDTO group,
            @PathVariable Long id
    ) {
        GroupResponseDTO newGroup = groupService.update(id,group);
        return ResponseEntity.ok(newGroup);
    }

    @DeleteMapping("deleteGroup/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
