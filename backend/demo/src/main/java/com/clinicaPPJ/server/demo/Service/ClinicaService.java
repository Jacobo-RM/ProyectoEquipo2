package com.clinicaPPJ.server.demo.Service;

import com.clinicaPPJ.server.demo.Model.Mascota;
import com.clinicaPPJ.server.demo.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }
}