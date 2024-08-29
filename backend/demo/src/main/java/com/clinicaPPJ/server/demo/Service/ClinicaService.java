package com.clinicaPPJ.server.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinicaPPJ.server.demo.Model.Cliente;
import com.clinicaPPJ.server.demo.Model.Mascota;
import com.clinicaPPJ.server.demo.Model.Veterinario;
import com.clinicaPPJ.server.demo.Repository.ClienteRepository;
import com.clinicaPPJ.server.demo.Repository.MascotaRepository;
import com.clinicaPPJ.server.demo.Repository.VeterinarioRepository;

@Service
@Transactional
public class ClinicaService {

    private MascotaRepository mascotaRepository;
    private ClienteRepository clienteRepository;
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    public ClinicaService(MascotaRepository mascotaRepository, ClienteRepository clienteRepository,
            VeterinarioRepository veterinarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.clienteRepository = clienteRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @Transactional(readOnly = true)
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Veterinario> obtenerTodosLosVeterinarios() {
        return veterinarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Mascota> obtenerMascotasPorDniCliente(String dniCliente) {
        return mascotaRepository.findByClienteDni(dniCliente);
    }

    @Transactional(readOnly = true)
    public List<Mascota> obtenerMascotasPorDniVeterinario(String dniVeterinario) {
        return mascotaRepository.findByVeterinarioDni(dniVeterinario);
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Veterinario guardarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public void agregarMascotaAVeterinario(int idMascota, int dniVeterinario) {
        Mascota mascota = mascotaRepository.findById(idMascota).orElse(null);
        Veterinario veterinario = veterinarioRepository.findById(dniVeterinario).orElse(null);
        if (mascota != null && veterinario != null) {
            mascota.setVeterinario(veterinario);
            mascotaRepository.save(mascota);
        }
    }

    public void agregarMascotaACliente(int idMascota, int dniCliente) {
        Mascota mascota = mascotaRepository.findById(idMascota).orElse(null);
        Cliente cliente = clienteRepository.findById(dniCliente).orElse(null);
        if (mascota != null && cliente != null) {
            mascota.setCliente(cliente);
            mascotaRepository.save(mascota);
        }
    }

    public void actualizarMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    public void actualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void borrarMascota(int idMascota) {
        mascotaRepository.deleteById(idMascota);
    }

    public void borrarCliente(int dniCliente) {
        clienteRepository.deleteById(dniCliente);
    }

}