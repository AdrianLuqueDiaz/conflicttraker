package com.example.conflicttracker.service;

import com.example.conflicttracker.dto.ConflictDTO;
import com.example.conflicttracker.model.Conflict;
import com.example.conflicttracker.model.Country;
import com.example.conflicttracker.repository.ConflictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConflictService {

    private final ConflictRepository conflictRepository;

    public ConflictService(ConflictRepository conflictRepository) {
        this.conflictRepository = conflictRepository;
    }

    public List<ConflictDTO> getAllConflicts() {
        return conflictRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ConflictDTO convertToDTO(Conflict conflict) {
        List<String> countries = conflict.getCountries() != null ?
                conflict.getCountries().stream().map(Country::getNombre).toList() :
                List.of();

        return new ConflictDTO(
                conflict.getId(),
                conflict.getNombre(),
                conflict.getFechaInicio(),
                conflict.getEstado(),
                conflict.getDescripcion(),
                countries
        );
    }

    public Conflict saveConflict(Conflict conflict) {
        return conflictRepository.save(conflict);
    }

    public void deleteConflict(Long id) {
        conflictRepository.deleteById(id);
    }
}
