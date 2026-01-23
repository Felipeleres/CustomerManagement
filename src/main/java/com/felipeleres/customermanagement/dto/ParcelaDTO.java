package com.felipeleres.customermanagement.dto;

import com.felipeleres.customermanagement.entities.Pagamento;
import com.felipeleres.customermanagement.entities.Parcela;
import com.felipeleres.customermanagement.enums.StatusPagamento;
import jakarta.persistence.*;

import java.time.LocalDate;

public class ParcelaDTO {


    private Long id;
    private Double valor;
    private LocalDate dataParcela;
    private StatusPagamento statusPagamento;
    private Long pagamentoId;

    public ParcelaDTO(){

    }

    public ParcelaDTO(Long id, Double valor, LocalDate dataParcela, StatusPagamento statusPagamento, Long pagamento) {
        this.id = id;
        this.valor = valor;
        this.dataParcela = dataParcela;
        this.statusPagamento = statusPagamento;
        this.pagamentoId = pagamento;
    }

    public ParcelaDTO(Parcela parcela) {
        id = parcela.getId();
        valor = parcela.getValor();
        dataParcela = parcela.getDataParcela();
        statusPagamento = parcela.getStatusPagamento();
        pagamentoId =  parcela.getPagamento().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataParcela() {
        return dataParcela;
    }

    public void setDataParcela(LocalDate dataParcela) {
        this.dataParcela = dataParcela;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Long getPagamento() {
        return pagamentoId;
    }

    public void setPagamento(Long pagamento) {
        this.pagamentoId = pagamento;
    }
}
