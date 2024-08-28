package com.clinicaPPJ.server.demo.Service;

import com.clinicaPPJ.server.demo.Model.Cliente;
import com.clinicaPPJ.server.demo.Model.Mascota;
import com.clinicaPPJ.server.demo.Repository.ClienteRepository;
import com.clinicaPPJ.server.demo.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClinicaService {

    private MascotaRepository mascotaRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public ClinicaService(MascotaRepository mascotaRepository, ClienteRepository clienteRepository) {
        this.mascotaRepository = mascotaRepository;
        this.clienteRepository = clienteRepository;
    }


    @Transactional(readOnly = true)
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Transactional(readOnly = true)
     public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

}