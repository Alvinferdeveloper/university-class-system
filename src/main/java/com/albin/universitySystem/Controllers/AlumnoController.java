package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.AlumnoDTO;
import com.albin.universitySystem.Entitites.Alumno;
import com.albin.universitySystem.Repositories.AlumnoRepository;
import com.albin.universitySystem.Services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @PostMapping(path = "/addAlumno", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AlumnoDTO> insertAlumno(@Valid @RequestBody AlumnoDTO alumno) {
        AlumnoDTO newAlumno = alumnoService.insert(alumno);
        return ResponseEntity.ok(newAlumno);
    }

    @GetMapping("/getAlumno/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable Long id) {
        AlumnoDTO alumno = alumnoService.findById(id);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping("/getAllAlumnos")
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        List<AlumnoDTO> alumnos = alumnoService.findAll();
        return ResponseEntity.ok(alumnos);
    }

    @PutMapping("/updateAlumno")
    public ResponseEntity<AlumnoDTO> updateAlumno(@RequestBody AlumnoDTO alumno) {
        AlumnoDTO newAlumno = alumnoService.update(alumno);
        return ResponseEntity.ok(newAlumno);
    }
    @DeleteMapping("deleteAlumno/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
