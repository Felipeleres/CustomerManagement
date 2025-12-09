package com.felipeleres.customermanagement.entities;

import com.felipeleres.customermanagement.enums.StatusPagamento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_Parcela")
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private LocalDate dataParcela;
    private StatusPagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    public Parcela (){

    }

    public Parcela(Long id, Double valor, LocalDate dataParcela, StatusPagamento statusPagamento,Pagamento pagamento) {
        this.id = id;
        this.valor = valor;
        this.dataParcela = dataParcela;
        this.statusPagamento = statusPagamento;
        this.pagamento = pagamento;
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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
