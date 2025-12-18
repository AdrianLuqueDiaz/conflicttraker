package com.example.conflicttracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conflict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String nombre;

    private LocalDate fechaInicio;

    @Enumerated(EnumType.STRING)
    private EstadoConflicto estado;

    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "conflict_country",
            joinColumns = @JoinColumn(name = "conflict_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> paises = new ArrayList<>();

    // ----- GETTERS Y SETTERS -----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public EstadoConflicto getEstado() {
        return estado;
    }

    public void setEstado(EstadoConflicto estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Country> getPaises() {
        return paises;
    }

    public void setPaises(List<Country> paises) {
        this.paises = paises;
    }
}
