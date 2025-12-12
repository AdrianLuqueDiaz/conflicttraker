package com.example.conflicttracker.dto;

import java.time.LocalDate;
import java.util.List;

public class ConflictDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaInicio;
    private String estado;
    private String descripcion;
    private List<String> countries;

    public ConflictDTO() {}

    public ConflictDTO(Long id, String nombre, LocalDate fechaInicio, String estado, String descripcion, List<String> countries) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.descripcion = descripcion;
        this.countries = countries;
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
    public List<String> getCountries() { return countries; }
    public void setCountries(List<String> countries) { this.countries = countries; }
}
