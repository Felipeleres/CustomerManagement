package com.felipeleres.customermanagement.services;

import com.felipeleres.customermanagement.dto.ProcessoCliDTO;
import com.felipeleres.customermanagement.dto.ProcessoDTO;
import com.felipeleres.customermanagement.entities.Cliente;
import com.felipeleres.customermanagement.entities.Processo;
import com.felipeleres.customermanagement.repositories.ClienteRepository;
import com.felipeleres.customermanagement.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    public ProcessoRepository processoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ProcessoDTO> buscarProcessos(){
        List<Processo> processos = processoRepository.findAll();
        return processos.stream().map(x -> new ProcessoDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public ProcessoCliDTO processo (Long id){
        Optional<Processo> resultado = processoRepository.findById(id);
        Processo processo = resultado.get();
        return new ProcessoCliDTO(processo);
    }


    @Transactional
    public ProcessoCliDTO inserirProcesso(ProcessoCliDTO processoCliDTO){
        Cliente cliente = clienteRepository.getReferenceById(processoCliDTO.getCliente().getId());
        Processo processo = new Processo();
        processo.setNumero(processoCliDTO.getNumero());
        processo.setDescricao(processoCliDTO.getDescricao());
        processo.setData(processoCliDTO.getData());
        processo.setValor(processoCliDTO.getValor());
        processo.setSituacao(processoCliDTO.getSituacao());
        processo.setCliente(cliente);
        processo.setFormaPagamento(processoCliDTO.getFormaPagamento());
        processo = processoRepository.save(processo);

        return new ProcessoCliDTO(processo);
    }

    @Transactional
    public ProcessoDTO atualizar( Long id, ProcessoDTO processoDTO){

        Processo processo =  processoRepository.getReferenceById(id);

        processo.setNumero(processoDTO.getNumero());
        processo.setDescricao(processoDTO.getDescricao());
        processo.setData(processoDTO.getData());
        processo.setValor(processoDTO.getValor());
        processo.setSituacao(processoDTO.getSituacao());
        processo.setFormaPagamento(processoDTO.getFormaPagamento());

        processo =  processoRepository.save(processo);
        return new ProcessoDTO(processo);
    }

}
