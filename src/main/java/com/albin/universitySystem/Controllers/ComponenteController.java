package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.ComponenteRequestDTO;
import com.albin.universitySystem.DTOs.Response.ComponenteResponseDTO;
import com.albin.universitySystem.Services.ComponenteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/componente")
@AllArgsConstructor
public class ComponenteController {
    private final ComponenteService componenteService;
    @PostMapping("/addComponente")
    public ResponseEntity<ComponenteResponseDTO> insertComponente(@Valid  @RequestBody ComponenteRequestDTO componente) {
        ComponenteResponseDTO newComponente = componenteService.insert(componente);
        return ResponseEntity.ok(newComponente);
    }
    @GetMapping("/getComponente/{id}")
    public ResponseEntity<ComponenteResponseDTO> getComponente(@PathVariable Long id){
        ComponenteResponseDTO componente =  componenteService.findById(id);
        return ResponseEntity.ok(componente);
    }
}
