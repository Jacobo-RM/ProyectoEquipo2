package com.clinicaPPJ.server.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicaPPJ.server.demo.Model.Cliente;
import com.clinicaPPJ.server.demo.Model.Mascota;
import com.clinicaPPJ.server.demo.Model.Veterinario;
import com.clinicaPPJ.server.demo.Service.ClinicaService;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping("/mascotas")
    public List<Mascota> getAllMascotas() {
        return clinicaService.getAllMascotas();
    }

    @GetMapping("/clientes")
    public List<Cliente> obtenerTodosLosClientes() {
        return clinicaService.obtenerTodosLosClientes();
    }

    @GetMapping("/veterinarios")
    public List<Veterinario> obtenerTodosLosVeterinarios() {
        return clinicaService.obtenerTodosLosVeterinarios();
    }

    @GetMapping("/mascotas/cliente/{dniCliente}")
    public List<Mascota> obtenerMascotasPorDniCliente(@PathVariable String dniCliente) {
        return clinicaService.obtenerMascotasPorDniCliente(dniCliente);
    }

    @GetMapping("/mascotas/veterinario/{dniVeterinario}")
    public List<Mascota> obtenerMascotasPorDniVeterinario(@PathVariable String dniVeterinario) {
        return clinicaService.obtenerMascotasPorDniVeterinario(dniVeterinario);
    }

    @PostMapping("/agregarMascotas")
    public Mascota guardarMascota(Mascota mascota) {
        return clinicaService.guardarMascota(mascota);
    }

    @PostMapping("/agregarClientes")
    public Cliente guardarCliente(Cliente cliente) {
        return clinicaService.guardarCliente(cliente);
    }

    @PostMapping("/agregarVeterinarios")
    public Veterinario guardarVeterinario(Veterinario veterinario) {
        return clinicaService.guardarVeterinario(veterinario);
    }

    @PostMapping("/agregarMascotaAVeterinario")
    public void agregarMascotaAVeterinario(int idMascota, int dniVeterinario) {
        clinicaService.agregarMascotaAVeterinario(idMascota, dniVeterinario);
    }

    @PostMapping("/agregarMascotaACliente")
    public void agregarMascotaACliente(int idMascota, int dniCliente) {
        clinicaService.agregarMascotaACliente(idMascota, dniCliente);
    }

    @PutMapping("/actualizarMascota")
    public void actualizarMascota(Mascota mascota) {
        clinicaService.actualizarMascota(mascota);
    }

    @PutMapping("/actualizarCliente")
    public void actualizarCliente(Cliente cliente) {
        clinicaService.actualizarCliente(cliente);
    }

    @DeleteMapping("/eliminarMascota")
    public void eliminarMascota(int idMascota) {
        clinicaService.borrarMascota(idMascota);
    }

    @DeleteMapping("/eliminarCliente")
    public void eliminarCliente(int dniCliente) {
        clinicaService.borrarCliente(dniCliente);
    }

}