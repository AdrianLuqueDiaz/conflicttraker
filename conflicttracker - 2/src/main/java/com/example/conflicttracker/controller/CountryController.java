package com.example.conflicttracker.controller;

import com.example.conflicttracker.dto.CountryDTO;
import com.example.conflicttracker.model.Country;
import com.example.conflicttracker.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService servicioPais;

    public CountryController(CountryService servicioPais) {
        this.servicioPais = servicioPais;
    }

    @GetMapping
    public List<CountryDTO> obtenerTodos() {
        return servicioPais.obtenerTodos().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> obtenerPorId(@PathVariable Long id) {
        return servicioPais.obtenerPorId(id)
                .map(pais -> ResponseEntity.ok(convertirADTO(pais)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CountryDTO> crear(@RequestBody CountryDTO dto) {
        Country pais = new Country();
        pais.setNombre(dto.getNombre());
        pais.setCodigo(dto.getCodigo());
        Country guardado = servicioPais.guardar(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertirADTO(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> actualizar(@PathVariable Long id, @RequestBody CountryDTO dto) {
        return servicioPais.obtenerPorId(id)
                .map(pais -> {
                    pais.setNombre(dto.getNombre());
                    pais.setCodigo(dto.getCodigo());
                    Country actualizado = servicioPais.guardar(pais);
                    return ResponseEntity.ok(convertirADTO(actualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        // Implementar validación antes de borrar 
        System.out.println("--- INTENTO DE BORRADO BLOQUEADO TEMPORALMENTE ---");
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build(); 
    }

    private CountryDTO convertirADTO(Country pais) {
        CountryDTO dto = new CountryDTO();
        dto.setId(pais.getId());
        dto.setNombre(pais.getNombre());
        dto.setCodigo(pais.getCodigo());
        return dto;
    }
}
