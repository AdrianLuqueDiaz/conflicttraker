package com.example.conflicttracker.service;

import com.example.conflicttracker.model.Conflict;
import com.example.conflicttracker.model.EstadoConflicto;
import com.example.conflicttracker.repository.ConflictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConflictService {

    private final ConflictRepository repositorioConflicto;

    public ConflictService(ConflictRepository repositorioConflicto) {
        this.repositorioConflicto = repositorioConflicto;
    }

    public List<Conflict> obtenerTodos() {
        return repositorioConflicto.findAll();
    }

    public Optional<Conflict> obtenerPorId(Long id) {
        return repositorioConflicto.findById(id);
    }

    public Conflict guardar(Conflict conflicto) {
        return repositorioConflicto.save(conflicto);
    }

    public void eliminarPorId(Long id) {
        repositorioConflicto.deleteById(id);
    }

    public List<Conflict> obtenerPorEstado(EstadoConflicto estado) {
        return repositorioConflicto.findByEstado(estado);
    }
}
