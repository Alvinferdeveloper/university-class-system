package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.ComponenteRequest;
import com.albin.universitySystem.DTOs.Response.ComponenteResponse;
import com.albin.universitySystem.Services.ComponenteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/componentes")
@AllArgsConstructor
public class ComponenteController {
    private final ComponenteService componenteService;
    @PostMapping
    public ResponseEntity<ComponenteResponse> createComponente(@Valid  @RequestBody ComponenteRequest componente) {
        ComponenteResponse newComponente = componenteService.insert(componente);
        return ResponseEntity.ok(newComponente);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ComponenteResponse> getComponenteById(@PathVariable Long id){
        ComponenteResponse componente =  componenteService.findById(id);
        return ResponseEntity.ok(componente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComponenteResponse> updateComponente(
            @Valid @RequestBody ComponenteRequest componente,
            @PathVariable Long id
    ) {
        ComponenteResponse newComponente = componenteService.update(id, componente);
        return ResponseEntity.ok(newComponente);
    }

    @GetMapping
    public ResponseEntity<List<ComponenteResponse>> getAllComponentes() {
        List<ComponenteResponse> componenteResponses = componenteService.findAll();
        return ResponseEntity.ok(componenteResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComponente(@PathVariable Long id) {
        componenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
