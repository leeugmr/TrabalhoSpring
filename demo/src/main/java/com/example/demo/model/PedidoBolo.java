package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class PedidoBolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O sabor do bolo não pode estar vazio")
    private String sabor;

    @NotNull(message = "A data de entrega não pode estar vazia")
    private LocalDate dataEntrega;

    @NotNull(message = "A quantidade do bolo não pode estar vazia")
    private Integer quantidade;

    public PedidoBolo() {
    }

    public PedidoBolo(Long id, String sabor, LocalDate dataEntrega, Integer quantidade) {
        this.id = id;
        this.sabor = sabor;
        this.dataEntrega = dataEntrega;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
