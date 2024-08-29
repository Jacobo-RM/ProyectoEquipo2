package com.clinicaPPJ.server.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicaPPJ.server.demo.Model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByClienteDni(String dniCliente);

    List<Mascota> findByVeterinarioDni(String dniVeterinario);
}