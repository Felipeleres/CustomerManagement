package com.felipeleres.customermanagement.dto;

import com.felipeleres.customermanagement.entities.Processo;
import com.felipeleres.customermanagement.enums.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProcessoDTO {

    private Long id;
    private String numero;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private String situacao;
    private FormaPagamento formaPagamento;

    public ProcessoDTO(){

    }

    public ProcessoDTO(Long id, String descricao, String numero, LocalDate data, BigDecimal valor, String situacao,FormaPagamento formaPagamento) {
        this.id = id;
        this.descricao = descricao;
        this.numero = numero;
        this.data = data;
        this.valor = valor;
        this.situacao = situacao;
        this.formaPagamento = formaPagamento;
    }

    public ProcessoDTO(Processo processo) {
        id = processo.getId();
        descricao = processo.getDescricao();
        numero = processo.getNumero();
        data = processo.getData();
        valor = processo.getValor();
        situacao = processo.getSituacao();
        formaPagamento = processo.getFormaPagamento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}