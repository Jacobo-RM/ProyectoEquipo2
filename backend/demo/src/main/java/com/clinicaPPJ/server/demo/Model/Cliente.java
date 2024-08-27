package com.clinicaPPJ.server.demo.Model;

public class Cliente extends Persona {

    private int numeroVisitas;

    public Cliente() {
    }
   
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


    
}

