package com.clinicaPPJ.server.demo.Repository;

import com.clinicaPPJ.server.demo.Model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {
}