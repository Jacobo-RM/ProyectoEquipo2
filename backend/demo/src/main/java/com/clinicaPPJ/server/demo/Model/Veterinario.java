package com.clinicaPPJ.server.demo.Model;

public class Veterinario extends Persona {
    private String especialidad;

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
}