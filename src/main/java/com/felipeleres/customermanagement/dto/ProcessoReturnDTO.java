package com.felipeleres.customermanagement.dto;

import com.felipeleres.customermanagement.entities.Processo;
import com.felipeleres.customermanagement.enums.FormaPagamento;
import com.felipeleres.customermanagement.enums.Situacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ProcessoReturnDTO {

    private Long id;
    @NotNull(message = "Campo requirido, informe um número de processo!")
    private String numero;
    private String descricao;
    private LocalDate data;
    @NotNull(message = "Campo requirido, informe um número de processo!")
    @Positive(message = "O valor deve ser positivo!")
    private Double valor;
    private Situacao situacao;
    private ClienteDTO cliente;
    private FormaPagamento formaPagamento;

    public ProcessoReturnDTO(){

    }

    public ProcessoReturnDTO(Long id, String descricao, String numero, LocalDate data, Double valor, Situacao situacao, ClienteDTO cliente, FormaPagamento formaPagamento) {
        this.id = id;
        this.descricao = descricao;
        this.numero = numero;
        this.data = data;
        this.valor = valor;
        this.situacao = situacao;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
    }

    public ProcessoReturnDTO(Processo processo) {
        id = processo.getId();
        descricao = processo.getDescricao();
        numero = processo.getNumero();
        data = processo.getData();
        valor = processo.getValor();
        situacao = processo.getSituacao();
        cliente =  new ClienteDTO(processo.getCliente());
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public ClienteDTO getCliente(){
        return cliente;
    }

    public void setCliente(ClienteDTO cliente){
        this.cliente = cliente;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}