package com.clinicaPPJ.server.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicaPPJ.server.demo.Model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, String> {
}