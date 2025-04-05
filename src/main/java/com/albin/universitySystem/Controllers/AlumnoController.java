package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.AlumnoRequestDTO;
import com.albin.universitySystem.DTOs.Response.AlumnoResponseDTO;
import com.albin.universitySystem.Services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @PostMapping(path = "/addAlumno", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AlumnoResponseDTO> insertAlumno(@Valid @RequestBody AlumnoRequestDTO alumno) {
        AlumnoResponseDTO newAlumno = alumnoService.insert(alumno);
        return ResponseEntity.ok(newAlumno);
    }

    @GetMapping("/getAlumno/{id}")
    public ResponseEntity<AlumnoResponseDTO> getAlumnoById(@PathVariable Long id) {
        AlumnoResponseDTO alumno = alumnoService.findById(id);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping("/getAllAlumnos")
    public ResponseEntity<List<AlumnoResponseDTO>> getAllAlumnos() {
        List<AlumnoResponseDTO> alumnos = alumnoService.findAll();
        return ResponseEntity.ok(alumnos);
    }

    @PutMapping("/updateAlumno/{id}")
    public ResponseEntity<AlumnoResponseDTO> updateAlumno(
            @PathVariable Long id,
            @RequestBody AlumnoRequestDTO alumno) {
        AlumnoResponseDTO newAlumno = alumnoService.update(id, alumno);
        return ResponseEntity.ok(newAlumno);
    }
    @DeleteMapping("deleteAlumno/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
