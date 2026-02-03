package com.felipeleres.customermanagement.dto;

import com.felipeleres.customermanagement.entities.Pagamento;
import com.felipeleres.customermanagement.enums.StatusPagamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PagamentoReturnDTO {


    private Long id;
    private StatusPagamento statusPagamento;
    private ProcessoDTO processo;
    private Integer quantidadeParcelas;
    private BigDecimal valorParcela;
    private List<ParcelaDTO> parcelas = new ArrayList<>();

    public PagamentoReturnDTO(){

    }

    public PagamentoReturnDTO(Long id, StatusPagamento statusPagamento, ProcessoDTO processo, Integer quantidadeParcelas, BigDecimal valorParcela) {
        this.id = id;
        this.statusPagamento = statusPagamento;
        this.processo = processo;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcela = valorParcela;
    }


    public PagamentoReturnDTO(Pagamento pagamento) {
        id = pagamento.getId();
        statusPagamento = pagamento.getStatusPagamento();
        processo = new ProcessoDTO(pagamento.getProcesso());
        quantidadeParcelas = pagamento.getQuantidadeParcelas();
        valorParcela = pagamento.getValorParcela();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public ProcessoDTO getProcesso() {
        return processo;
    }

    public void setProcesso(ProcessoDTO processo) {
        this.processo = processo;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public void addParcela(ParcelaDTO parcela){
        parcelas.add(parcela);
    }

    public List<ParcelaDTO> getParcelas(){
        return parcelas;
    }

    public void removerParcela(ParcelaDTO parcela){
        parcelas.remove(parcela);
    }

}
