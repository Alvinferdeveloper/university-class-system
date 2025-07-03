package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.ProfesorRequest;
import com.albin.universitySystem.DTOs.Response.ProfesorResponse;
import com.albin.universitySystem.Services.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public ResponseEntity<ProfesorResponse> createProfesor(@Valid @RequestBody ProfesorRequest profesor) {
        ProfesorResponse newProfesor = profesorService.insert(profesor);
        return new ResponseEntity<>(newProfesor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponse> getProfesorById(@PathVariable Long id) {
        ProfesorResponse profesor = profesorService.findById(id);
        return ResponseEntity.ok(profesor);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponse>> getAllProfesores() {
        List<ProfesorResponse> profesores = profesorService.findAll();
        return ResponseEntity.ok(profesores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponse> updateProfesor(
            @Valid @RequestBody ProfesorRequest updateRequest,
            @PathVariable Long id
    ) {
        ProfesorResponse updatedProfesorResponse = profesorService.update(id, updateRequest);
        return ResponseEntity.ok(updatedProfesorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
