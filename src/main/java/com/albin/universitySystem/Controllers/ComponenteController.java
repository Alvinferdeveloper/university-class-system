package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.ComponenteRequestDTO;
import com.albin.universitySystem.DTOs.Response.ComponenteResponseDTO;
import com.albin.universitySystem.Services.ComponenteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/updateComponente/{id}")
    public ResponseEntity<ComponenteResponseDTO> updateComponente(
            @Valid @RequestBody ComponenteRequestDTO componente,
            @PathVariable Long id
    ) {
        ComponenteResponseDTO newComponente = componenteService.update(id, componente);
        return ResponseEntity.ok(newComponente);
    }

    @GetMapping("/getAllComponentes")
    public ResponseEntity<List<ComponenteResponseDTO>> getAllComponentes() {
        List<ComponenteResponseDTO> componentes = componenteService.findAll();
        return ResponseEntity.ok(componentes);
    }

    @DeleteMapping("/deleteComponente/{id}")
    public ResponseEntity<Void> deleteComponente(@PathVariable Long id) {
        componenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
