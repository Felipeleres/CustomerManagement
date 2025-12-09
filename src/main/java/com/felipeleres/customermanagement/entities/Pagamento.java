package com.felipeleres.customermanagement.entities;

import com.felipeleres.customermanagement.enums.StatusPagamento;
import com.felipeleres.customermanagement.enums.FormaPagamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusPagamento statusPagamento;
    @OneToOne
    @JoinColumn(name = "processo_id")
    private Processo processo;
    private Integer quantidadeParcelas;
    private Double valorParcela;

    @OneToMany(mappedBy = "pagamento",cascade = CascadeType.ALL)
    private List<Parcela> parcelas = new ArrayList<>();

    public Pagamento(){

    }

    public Pagamento(Long id, StatusPagamento statusPagamento, Processo processo, Integer quantidadeParcelas, Double valorParcela) {
        this.id = id;
        this.statusPagamento = statusPagamento;
        this.processo = processo;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcela = valorParcela;
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

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public void addParcela(Parcela parcela){
        parcelas.add(parcela);
    }

    public void removerParcela(Parcela parcela){
        parcelas.remove(parcela);
    }



}
