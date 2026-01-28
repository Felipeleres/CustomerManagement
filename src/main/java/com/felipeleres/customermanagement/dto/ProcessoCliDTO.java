package com.felipeleres.customermanagement.dto;

import com.felipeleres.customermanagement.entities.Cliente;
import com.felipeleres.customermanagement.entities.Processo;
import com.felipeleres.customermanagement.enums.FormaPagamento;
import com.felipeleres.customermanagement.enums.Situacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProcessoCliDTO {

    private Long id;
    @NotNull(message = "Campo requirido, informe um número de processo!")
    private String numero;
    private String descricao;
    private LocalDate data;
    @NotNull(message = "Campo requirido, informe um número de processo!")
    @Positive(message = "O valor deve ser positivo!")
    private BigDecimal valor;
    private Situacao situacao;
    private Long clienteId;
    private FormaPagamento formaPagamento;

    public ProcessoCliDTO(){

    }

    public ProcessoCliDTO(Long id, String descricao, String numero, LocalDate data, BigDecimal valor, Situacao situacao, Long clienteId,FormaPagamento formaPagamento) {
        this.id = id;
        this.descricao = descricao;
        this.numero = numero;
        this.data = data;
        this.valor = valor;
        this.situacao = situacao;
        this.clienteId = clienteId;
        this.formaPagamento = formaPagamento;
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

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Long getClienteId(){
        return clienteId;
    }

    public void setClienteId(Long clienteId){this.clienteId = clienteId;}

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}