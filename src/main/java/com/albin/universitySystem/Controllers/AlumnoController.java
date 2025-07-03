package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.AlumnoRequest;
import com.albin.universitySystem.DTOs.Response.AlumnoResponse;
import com.albin.universitySystem.Services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @PostMapping()
    public ResponseEntity<AlumnoResponse> createAlumno(@Valid @RequestBody AlumnoRequest alumno) {
        AlumnoResponse newAlumno = alumnoService.insert(alumno);
        return ResponseEntity.ok(newAlumno);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('PROFESOR')")
    public ResponseEntity<AlumnoResponse> getAlumnoById(@PathVariable Long id) {
        AlumnoResponse alumno = alumnoService.findById(id);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping
    public ResponseEntity<List<AlumnoResponse>> getAllAlumnos() {
        List<AlumnoResponse> alumnos = alumnoService.findAll();
        return ResponseEntity.ok(alumnos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponse> updateAlumno(
            @PathVariable Long id,
            @RequestBody AlumnoRequest updateRequest) {
        AlumnoResponse updatedAlumnoResponse = alumnoService.update(id, updateRequest);
        return ResponseEntity.ok(updatedAlumnoResponse);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_ALUMNO')")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
