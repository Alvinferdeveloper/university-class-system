package com.albin.universitySystem.Controllers;

import com.albin.universitySystem.DTOs.Request.ComponenteRequestDTO;
import com.albin.universitySystem.DTOs.Response.ComponenteResponseDTO;
import com.albin.universitySystem.Services.ComponenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/componente")
@AllArgsConstructor
public class ComponenteController {
    private final ComponenteService componenteService;
    @PostMapping("/addComponente")
    public ResponseEntity<ComponenteResponseDTO> insertComponente(@RequestBody ComponenteRequestDTO componente) {
        ComponenteResponseDTO newComponente = componenteService.insert(componente);
        return ResponseEntity.ok(newComponente);
    }
}
