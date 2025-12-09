package com.felipeleres.customermanagement.controllers;

import com.felipeleres.customermanagement.dto.ClienteDTO;
import com.felipeleres.customermanagement.entities.Cliente;
import com.felipeleres.customermanagement.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> buscarClientes(Pageable pageable){
        Page<ClienteDTO> dto = clienteService.buscarTodos(pageable);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> cliente (@PathVariable Long id){
        ClienteDTO  clienteDTO =  clienteService.buscarCliente(id);
        return ResponseEntity.ok(clienteDTO);
    }


    @PostMapping
    public ResponseEntity<ClienteDTO> inserir(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO dto = clienteService.inserir(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> atualizar (@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        clienteDTO = clienteService.atualizar(id,clienteDTO);
        return ResponseEntity.ok(clienteDTO);
    }


}
