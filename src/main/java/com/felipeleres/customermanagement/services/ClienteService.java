package com.felipeleres.customermanagement.services;

import com.felipeleres.customermanagement.dto.ClienteDTO;
import com.felipeleres.customermanagement.entities.Cliente;
import com.felipeleres.customermanagement.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Cliente cliente =  resultado.get();
        return new ClienteDTO(cliente);
    }


    @Transactional
    public ClienteDTO inserir (ClienteDTO clienteDTO){

        Cliente cliente = new Cliente();
        cliente.setName(clienteDTO.getName());
        cliente.setCpf(clienteDTO.getCpf());

        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);
    }

    @Transactional
    public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO){
        Cliente cliente =  clienteRepository.getReferenceById(id);

        cliente.setName(clienteDTO.getName());
        cliente.setCpf(clienteDTO.getCpf());
        cliente = clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }




}
