package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.ProfesorRequestDTO;
import com.albin.universitySystem.DTOs.Response.ProfesorResponseDTO;
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
    public ResponseEntity<ProfesorResponseDTO> createProfesor(@Valid @RequestBody ProfesorRequestDTO profesor) {
        ProfesorResponseDTO newProfesor = profesorService.insert(profesor);
        return new ResponseEntity<>(newProfesor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> getProfesorById(@PathVariable Long id) {
        ProfesorResponseDTO profesor = profesorService.findById(id);
        return ResponseEntity.ok(profesor);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponseDTO>> getAllProfesores() {
        List<ProfesorResponseDTO> profesores = profesorService.findAll();
        return ResponseEntity.ok(profesores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> updateProfesor(
            @Valid @RequestBody ProfesorRequestDTO profesor,
            @PathVariable Long id
    ) {
        ProfesorResponseDTO updatedProfesor = profesorService.update(id, profesor);
        return ResponseEntity.ok(updatedProfesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
