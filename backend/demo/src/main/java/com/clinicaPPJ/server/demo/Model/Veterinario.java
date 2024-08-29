package com.clinicaPPJ.server.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinario extends Persona {

    @Column
    private String especialidad;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas;

    public Veterinario() {
    }

    public Veterinario(String dni, String nombre, String direccion, String telefono, String especialidad) {
        super(dni, nombre, direccion, telefono, "Veterinario");
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
