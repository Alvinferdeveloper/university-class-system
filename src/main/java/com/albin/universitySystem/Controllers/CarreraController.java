package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.CarreraRequestDTO;
import com.albin.universitySystem.DTOs.Response.CarreraResponseDTO;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Services.CarreraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carreras")
@RequiredArgsConstructor
public class CarreraController {
    private final CarreraService carreraService;
    @PostMapping
    public ResponseEntity<CarreraResponseDTO> createCarrera(@Valid  @RequestBody  CarreraRequestDTO carreraRequestDTO) {
        CarreraResponseDTO newCarrera = carreraService.insert(carreraRequestDTO);
        return ResponseEntity.ok().body(newCarrera);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> getCarreraById(@PathVariable Long id) {
        CarreraResponseDTO carrera = carreraService.findById(id);
        return ResponseEntity.ok().body(carrera);
    }
    @GetMapping
    public ResponseEntity<List<CarreraResponseDTO>> getAllCarreras() {
        List<CarreraResponseDTO> carreras = carreraService.findAll();
        return ResponseEntity.ok().body(carreras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> updateCarrera(
            @RequestBody CarreraRequestDTO carreraReq,
            @PathVariable Long id
    ){
        CarreraResponseDTO carrera = carreraService.update(id, carreraReq);
        return ResponseEntity.ok().body(carrera);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Long id) {
        carreraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
