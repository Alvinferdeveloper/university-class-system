package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.CarreraRequestDTO;
import com.albin.universitySystem.DTOs.Response.CarreraResponseDTO;
import com.albin.universitySystem.Entitites.Carrera;
import com.albin.universitySystem.Services.CarreraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrera")
@RequiredArgsConstructor
public class CarreraController {
    private final CarreraService carreraService;
    @PostMapping("/addCarrera")
    public ResponseEntity<CarreraResponseDTO> insertCarrera(@Valid  @RequestBody  CarreraRequestDTO carreraRequestDTO) {
        CarreraResponseDTO newCarrera = carreraService.insert(carreraRequestDTO);
        return ResponseEntity.ok().body(newCarrera);
    }
    @GetMapping("/getCarrera/{id}")
    public ResponseEntity<CarreraResponseDTO> getCarrera(@PathVariable Long id) {
        CarreraResponseDTO carrera = carreraService.findById(id);
        return ResponseEntity.ok().body(carrera);
    }
}
