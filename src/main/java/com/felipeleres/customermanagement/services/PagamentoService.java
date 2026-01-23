package com.felipeleres.customermanagement.services;

import com.felipeleres.customermanagement.dto.PagamentoDTO;
import com.felipeleres.customermanagement.dto.ParcelaDTO;
import com.felipeleres.customermanagement.dto.ProcessoDTO;
import com.felipeleres.customermanagement.entities.Pagamento;
import com.felipeleres.customermanagement.entities.Parcela;
import com.felipeleres.customermanagement.entities.Processo;
import com.felipeleres.customermanagement.repositories.PagamentoRepository;
import com.felipeleres.customermanagement.repositories.ParcelaRepository;
import com.felipeleres.customermanagement.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProcessoRepository processoRepository;

    @Transactional
    public PagamentoDTO cadastrarPagamento (PagamentoDTO pagamentoDTO){

        Pagamento pagamento = new Pagamento();
        Processo processo =  processoRepository.getReferenceById(pagamentoDTO.getProcessoID());

        pagamento.setStatusPagamento(pagamentoDTO.getStatusPagamento());
        pagamento.setProcesso(processo);
        pagamento.setQuantidadeParcelas(pagamentoDTO.getQuantidadeParcelas());
        pagamento.setValorParcela(pagamentoDTO.getValorParcela());

        for(ParcelaDTO par: pagamentoDTO.getParcelas()){
            Parcela parcela = dtoToEntity(par);
            pagamento.addParcela(parcela);
        }

        pagamento = pagamentoRepository.save(pagamento);

        PagamentoDTO dto = new PagamentoDTO(pagamento);
        for(Parcela parce : pagamento.getParcelas()){
            dto.addParcela(new ParcelaDTO(parce));
        }
        return dto;
    }

    public Parcela dtoToEntity(ParcelaDTO parcelaDTO){
        Parcela parcela = new Parcela();
        parcela.setValor(parcelaDTO.getValor());
        parcela.setDataParcela(parcelaDTO.getDataParcela());
        parcela.setStatusPagamento(parcelaDTO.getStatusPagamento());
        return parcela;
    }



}
