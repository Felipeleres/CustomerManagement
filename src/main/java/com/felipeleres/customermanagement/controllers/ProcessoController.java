package com.felipeleres.customermanagement.controllers;

import com.felipeleres.customermanagement.dto.ProcessoCliDTO;
import com.felipeleres.customermanagement.dto.ProcessoDTO;
import com.felipeleres.customermanagement.services.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/processo")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @GetMapping
    public ResponseEntity<List<ProcessoDTO>> buscarProcessos(){
        List<ProcessoDTO> dto = processoService.buscarProcessos();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProcessoCliDTO> processo(@PathVariable Long id){
        ProcessoCliDTO processoCliDTO = processoService.processo(id);
        return ResponseEntity.ok(processoCliDTO);
    }


    @PostMapping
    public ResponseEntity<ProcessoCliDTO> inserirProcesso(@RequestBody ProcessoCliDTO processo){
        processo = processoService.inserirProcesso(processo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(processo.getId()).toUri();
        return ResponseEntity.created(uri).body(processo);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ProcessoDTO> atualizarProcesso(@PathVariable Long id, @RequestBody  ProcessoDTO processoDTO){
        processoDTO = processoService.atualizar(id,processoDTO);
        return ResponseEntity.ok(processoDTO);
    }

}
