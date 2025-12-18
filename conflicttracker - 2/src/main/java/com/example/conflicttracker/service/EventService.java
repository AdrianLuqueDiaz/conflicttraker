package com.example.conflicttracker.service;

import com.example.conflicttracker.model.Event;
import com.example.conflicttracker.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository repositorioEvento;

    public EventService(EventRepository repositorioEvento) {
        this.repositorioEvento = repositorioEvento;
    }

    public List<Event> obtenerTodos() {
        return repositorioEvento.findAll();
    }

    public Optional<Event> obtenerPorId(Long id) {
        return repositorioEvento.findById(id);
    }

    public Event guardar(Event evento) {
        return repositorioEvento.save(evento);
    }

    public void eliminarPorId(Long id) {
        repositorioEvento.deleteById(id);
    }
}
