package com.clinicaPPJ.server.demo.Repository;

import com.clinicaPPJ.server.demo.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}