package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.CarreraRequest;
import com.albin.universitySystem.DTOs.Response.CarreraResponse;
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
    public ResponseEntity<CarreraResponse> createCarrera(@Valid  @RequestBody CarreraRequest carreraRequestDTO) {
        CarreraResponse newCarrera = carreraService.insert(carreraRequestDTO);
        return ResponseEntity.ok().body(newCarrera);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarreraResponse> getCarreraById(@PathVariable Long id) {
        CarreraResponse carrera = carreraService.findById(id);
        return ResponseEntity.ok().body(carrera);
    }
    @GetMapping
    public ResponseEntity<List<CarreraResponse>> getAllCarreras() {
        List<CarreraResponse> carreras = carreraService.findAll();
        return ResponseEntity.ok().body(carreras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarreraResponse> updateCarrera(
            @RequestBody CarreraRequest updateRequest,
            @PathVariable Long id
    ){
        CarreraResponse updatedCarreraResponse = carreraService.update(id, updateRequest);
        return ResponseEntity.ok().body(updatedCarreraResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Long id) {
        carreraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
