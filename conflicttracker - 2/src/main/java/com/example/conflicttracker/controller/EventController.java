package com.example.conflicttracker.controller;

import com.example.conflicttracker.dto.EventDTO;
import com.example.conflicttracker.dto.EventCreateDTO;
import com.example.conflicttracker.model.Event;
import com.example.conflicttracker.service.EventService;
import com.example.conflicttracker.service.ConflictService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService servicioEvento;
    private final ConflictService servicioConflicto;

    public EventController(EventService servicioEvento, ConflictService servicioConflicto) {
        this.servicioEvento = servicioEvento;
        this.servicioConflicto = servicioConflicto;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        return ResponseEntity.ok(servicioEvento.obtenerTodos().stream().map(this::convertirADTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> obtenerPorId(@PathVariable Long id) {
        return servicioEvento.obtenerPorId(id)
                .map(evento -> ResponseEntity.ok(convertirADTO(evento)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventDTO> crear(@RequestBody EventCreateDTO dto) {
        Event evento = new Event();
        evento.setFecha(dto.getFecha());
        evento.setUbicacion(dto.getUbicacion());
        evento.setDescripcion(dto.getDescripcion());

        servicioConflicto.obtenerPorId(dto.getConflictoId()).ifPresent(evento::setConflicto);

        Event guardado = servicioEvento.guardar(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertirADTO(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody EventCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (servicioEvento.obtenerPorId(id).isPresent()) {
            servicioEvento.eliminarPorId(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private EventDTO convertirADTO(Event evento) {
        EventDTO dto = new EventDTO();
        dto.setId(evento.getId());
        dto.setFecha(evento.getFecha());
        dto.setUbicacion(evento.getUbicacion());
        dto.setDescripcion(evento.getDescripcion());
        dto.setConflictoId(evento.getConflicto() != null ? evento.getConflicto().getId() : null);
        return dto;
    }
}
