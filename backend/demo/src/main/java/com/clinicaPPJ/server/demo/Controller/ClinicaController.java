package com.clinicaPPJ.server.demo.Controller;

import com.clinicaPPJ.server.demo.Model.Cliente;
import com.clinicaPPJ.server.demo.Model.Mascota;
import com.clinicaPPJ.server.demo.Service.ClinicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}