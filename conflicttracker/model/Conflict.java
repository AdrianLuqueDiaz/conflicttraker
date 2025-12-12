package com.example.conflicttracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Conflict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaInicio;
    private String estado;
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "conflict_country",
            joinColumns = @JoinColumn(name = "conflict_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries;

    public Conflict() {}

    public Conflict(String nombre, LocalDate fechaInicio, String estado, String descripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public List<Country> getCountries() { return countries; }
    public void setCountries(List<Country> countries) { this.countries = countries; }
}
