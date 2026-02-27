package com.felipeleres.customermanagement.controllers;

import com.felipeleres.customermanagement.dto.ParcelaDTO;
import com.felipeleres.customermanagement.services.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/parcela")
public class ParcelaController {

    @Autowired
    ParcelaService parcelaService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParcelaDTO> atualizarParcela(@PathVariable Long id,  @RequestBody  ParcelaDTO parcelaDTO){
        ParcelaDTO dto = parcelaService.atualizarParcela(id,parcelaDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParcelaDTO> consultarParcela(@PathVariable Long id){
        ParcelaDTO dto = parcelaService.consultarParcela(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ParcelaDTO>> consultarParcelas(Pageable pageable){
        Page<ParcelaDTO> dto = parcelaService.consultarParcelas(pageable);
        return ResponseEntity.ok(dto);
    }

}
