package com.clinicaPPJ.server.demo.Model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente extends Persona {

    @Column
    private int numeroVisitas;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas;

    public Cliente() {}

    public Cliente(String dni, String nombre, String direccion, String telefono, int numeroVisitas) {
        super(dni, nombre, direccion, telefono, "Cliente");
        this.numeroVisitas = numeroVisitas;
    }

    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
