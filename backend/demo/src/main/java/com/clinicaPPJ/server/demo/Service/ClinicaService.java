package com.clinicaPPJ.server.demo.Service;

import com.clinicaPPJ.server.demo.Model.Cliente;
import com.clinicaPPJ.server.demo.Model.Mascota;
import com.clinicaPPJ.server.demo.Model.Veterinario;
import com.clinicaPPJ.server.demo.Repository.ClienteRepository;
import com.clinicaPPJ.server.demo.Repository.MascotaRepository;
import com.clinicaPPJ.server.demo.Repository.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClinicaService {

    private MascotaRepository mascotaRepository;
    private ClienteRepository clienteRepository;
    private VeterinarioRepository veterinarioRepository;
 

    @Autowired
    public ClinicaService(MascotaRepository mascotaRepository, ClienteRepository clienteRepository, VeterinarioRepository veterinarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.clienteRepository = clienteRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @Transactional(readOnly = true)
    public Mascota getMascotaById(int id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente getClienteById(String dni) {
        return clienteRepository.findById(dni).orElse(null);
    }

    @Transactional(readOnly = true)
     public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Veterinario> obtenerTodosLosVeterinarios() {
        return veterinarioRepository.findAll();
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

    public void agregarMascotaACliente(int idMascota, String dniCliente) {
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

    public void actualizarCliente(String dni, Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(dni);
        if (optionalCliente.isPresent()) {
            Cliente existingCliente = optionalCliente.get();
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setDireccion(cliente.getDireccion());
            existingCliente.setTelefono(cliente.getTelefono());
            existingCliente.setNumeroVisitas(cliente.getNumeroVisitas());
            clienteRepository.save(existingCliente);
        } 
    }

    public void borrarMascota(int idMascota) {
        mascotaRepository.deleteById(idMascota);
    }

    public void borrarCliente(String dniCliente) {
        clienteRepository.deleteById(dniCliente);
    }

    





}