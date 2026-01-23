package com.felipeleres.customermanagement.repositories;

import com.felipeleres.customermanagement.dto.ClienteDTO;
import com.felipeleres.customermanagement.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    public List<Cliente> findByNameContainingIgnoreCase (String nome);


}
