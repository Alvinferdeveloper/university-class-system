package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.GroupRequest;
import com.albin.universitySystem.DTOs.Response.GroupResponse;
import com.albin.universitySystem.Services.GroupService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<GroupResponse> createGroup(@Valid @RequestBody GroupRequest group) {
        GroupResponse newGroup = groupService.insert(group);
        return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponse> getGroupById(@PathVariable Long id) {
        GroupResponse group = groupService.findById(id);
        return ResponseEntity.ok(group);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponse>> getAllGroups() {
        List<GroupResponse> groups = groupService.findAll();
        return ResponseEntity.ok(groups);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupResponse> updateGroup(
            @Valid @RequestBody GroupRequest updateRequest,
            @PathVariable Long id
    ) {
        GroupResponse updatedGroupResponse = groupService.update(id,updateRequest);
        return ResponseEntity.ok(updatedGroupResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
