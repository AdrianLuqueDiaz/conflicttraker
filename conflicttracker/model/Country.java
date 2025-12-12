package com.example.conflicttracker.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "countries")
    private List<Conflict> conflicts;

    public Country() {}

    public Country(String nombre) {
        this.nombre = nombre;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Conflict> getConflicts() { return conflicts; }
    public void setConflicts(List<Conflict> conflicts) { this.conflicts = conflicts; }
}
