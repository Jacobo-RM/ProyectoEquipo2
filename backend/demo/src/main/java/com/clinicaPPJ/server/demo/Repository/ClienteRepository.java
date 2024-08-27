package com.clinicaPPJ.server.demo.Repository;

import com.clinicaPPJ.server.demo.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}