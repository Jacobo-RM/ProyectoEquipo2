package com.clinicaPPJ.server.demo.Repository;

import com.clinicaPPJ.server.demo.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}