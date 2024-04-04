package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O ID do cliente não pode estar vazio")
    private Long idCliente;

    @NotNull(message = "O ID do produto não pode estar vazio")
    private Long idProduto;

    @NotNull(message = "A quantidade do produto não pode estar vazia")
    private Integer quantidade;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, Long idProduto, Integer quantidade) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}


