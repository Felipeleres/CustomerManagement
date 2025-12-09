package com.felipeleres.customermanagement.repositories;

import com.felipeleres.customermanagement.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
