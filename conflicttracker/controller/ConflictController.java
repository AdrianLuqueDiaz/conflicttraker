package com.example.conflicttracker.controller;

import com.example.conflicttracker.dto.ConflictDTO;
import com.example.conflicttracker.model.Conflict;
import com.example.conflicttracker.service.ConflictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflicts")
public class ConflictController {

    private final ConflictService conflictService;

    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public List<ConflictDTO> getAllConflicts() {
        return conflictService.getAllConflicts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictDTO> getConflictById(@PathVariable Long id) {
        ConflictDTO conflictDTO = conflictService.getAllConflicts()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (conflictDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conflictDTO);
    }

    @PostMapping
    public Conflict createConflict(@RequestBody Conflict conflict) {
        return conflictService.saveConflict(conflict);
    }

    @DeleteMapping("/{id}")
    public void deleteConflict(@PathVariable Long id) {
        conflictService.deleteConflict(id);
    }
}
