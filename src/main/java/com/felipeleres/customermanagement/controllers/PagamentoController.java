package com.felipeleres.customermanagement.controllers;

import com.felipeleres.customermanagement.dto.FinanceiroDTO;
import com.felipeleres.customermanagement.dto.PagamentoDTO;
import com.felipeleres.customermanagement.dto.PagamentoReturnDTO;
import com.felipeleres.customermanagement.services.PagamentoService;
import com.felipeleres.customermanagement.services.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<Page<PagamentoReturnDTO>> buscarPagamentos(Pageable page){
        Page<PagamentoReturnDTO> dto =  pagamentoService.buscarTodos(page);
        PageRequest.of(0, 20, Sort.by("id").descending());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/total-pago")
    public ResponseEntity<FinanceiroDTO> totalRecebido (){
        FinanceiroDTO dto = pagamentoService.totalRecebido();
        return ResponseEntity.ok().body(dto);
    }




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
