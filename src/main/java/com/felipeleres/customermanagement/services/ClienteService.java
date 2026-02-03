package com.felipeleres.customermanagement.services;

import com.felipeleres.customermanagement.dto.ClienteDTO;
import com.felipeleres.customermanagement.dto.ClienteProDTO;
import com.felipeleres.customermanagement.entities.Cliente;
import com.felipeleres.customermanagement.repositories.ClienteRepository;
import com.felipeleres.customermanagement.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> buscarTodos(Pageable pageable){
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return clientes.map(x -> new ClienteDTO(x));
    }

    @Transactional(readOnly = true)
    public ClienteDTO buscarCliente(Long id){

            Optional<Cliente> resultado = clienteRepository.findById(id);
            Cliente cliente = resultado.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
            return new ClienteDTO(cliente);
    }
    @Transactional(readOnly = true)
    public List<ClienteProDTO> buscarClientePorNome(String nome){
        List<Cliente> clientes = clienteRepository.findByNameContainingIgnoreCase(nome);
        return clientes.stream().map(x -> new ClienteProDTO(x)).toList();
    }

    @Transactional
    public ClienteDTO inserir (ClienteDTO clienteDTO){

        Cliente cliente = new Cliente();
        cliente.setName(clienteDTO.getName());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());

        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);
    }

    @Transactional
    public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO){

        try {

            Cliente cliente = clienteRepository.getReferenceById(id);

            cliente.setName(clienteDTO.getName());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setTelefone(clienteDTO.getTelefone());
            cliente = clienteRepository.save(cliente);
            return new ClienteDTO(cliente);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException("Cliente não encontrado!");
        }
    }




}
