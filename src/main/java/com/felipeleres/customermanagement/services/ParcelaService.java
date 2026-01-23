package com.felipeleres.customermanagement.services;

import com.felipeleres.customermanagement.dto.ParcelaDTO;
import com.felipeleres.customermanagement.entities.Parcela;
import com.felipeleres.customermanagement.repositories.ParcelaRepository;
import com.felipeleres.customermanagement.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParcelaService {

    @Autowired
    ParcelaRepository parcelaRepository;

    @Transactional
    public ParcelaDTO atualizarParcela (Long id , ParcelaDTO parcelaDTO){
        Parcela parcela = parcelaRepository.getReferenceById(id);
        if(parcela != null) {
            parcela.setStatusPagamento(parcelaDTO.getStatusPagamento());
            parcela = parcelaRepository.save(parcela);
        }
        else{
            throw new ResourceNotFoundException("Parcela não Encontrada!");
        }
        return new ParcelaDTO(parcela);
    }

}
