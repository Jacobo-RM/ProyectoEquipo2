package com.clinicaPPJ.server.demo.Repository;

import com.clinicaPPJ.server.demo.Model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
}