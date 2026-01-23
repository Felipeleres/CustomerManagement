package com.felipeleres.customermanagement.controllers;

import com.felipeleres.customermanagement.dto.PagamentoDTO;
import com.felipeleres.customermanagement.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;


    @PostMapping
    public ResponseEntity<PagamentoDTO> cadastrarPagamento(@RequestBody PagamentoDTO pagamentoDTO){
        PagamentoDTO dto = pagamentoService.cadastrarPagamento(pagamentoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pagamentoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PagamentoDTO> atualizarPagamento(@PathVariable  Long id, @RequestBody PagamentoDTO pagamentoDTO){
        PagamentoDTO dto = pagamentoService.atualizarPagamento(id,pagamentoDTO);
        return ResponseEntity.ok(dto);
    }
}
