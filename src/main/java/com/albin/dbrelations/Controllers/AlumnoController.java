package com.albin.dbrelations.Controllers;

import com.albin.dbrelations.DTOs.AlumnoDTO;
import com.albin.dbrelations.Entitites.Alumno;
import com.albin.dbrelations.Services.AlumnoService;
import jakarta.validation.Valid;
import lombok.Getter;
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
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
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
    public ResponseEntity<AlumnoDTO> updateAlumno(@Valid @RequestBody AlumnoDTO alumno) {
        AlumnoDTO newAlumno = alumnoService.update(alumno);
        return ResponseEntity.ok(newAlumno);
    }

}
