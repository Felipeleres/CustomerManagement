package com.felipeleres.customermanagement.controllers;

import com.felipeleres.customermanagement.dto.ProcessoCliDTO;
import com.felipeleres.customermanagement.dto.ProcessoDTO;
import com.felipeleres.customermanagement.dto.ProcessoReturnDTO;
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
    public ResponseEntity<List<ProcessoReturnDTO>> buscarProcessos(){
        List<ProcessoReturnDTO> dto = processoService.buscarProcessos();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProcessoReturnDTO> processo(@PathVariable Long id){
        ProcessoReturnDTO processoreturnDTO = processoService.processo(id);
        return ResponseEntity.ok(processoreturnDTO);
    }


    @PostMapping
    public ResponseEntity<ProcessoReturnDTO> inserirProcesso(@RequestBody ProcessoCliDTO processo){
        ProcessoReturnDTO dto = processoService.inserirProcesso(processo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(processo.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ProcessoDTO> atualizarProcesso(@PathVariable Long id, @RequestBody  ProcessoDTO processoDTO){
        processoDTO = processoService.atualizar(id,processoDTO);
        return ResponseEntity.ok(processoDTO);
    }

}
