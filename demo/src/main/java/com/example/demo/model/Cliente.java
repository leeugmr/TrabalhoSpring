package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do cliente não pode estar vazio")
    private String nome;

    @NotEmpty(message = "O email do cliente não pode estar vazio")
    private String email;

    @OneToMany(cascade=CascadeType.ALL)
    private List<AvaliacaoComentario> listaAvaliacoes;

    public Cliente() {
        this.listaAvaliacoes = new ArrayList<>();
    }

    public Cliente(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.listaAvaliacoes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAvaliacao(AvaliacaoComentario avaliacao) {
        this.listaAvaliacoes.add(avaliacao);
    }

    public boolean removerAvaliacao(Long idAvaliacao) {
        return this.listaAvaliacoes.removeIf(avaliacao -> avaliacao.getId().equals(idAvaliacao));
    }

    public List<AvaliacaoComentario> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(List<AvaliacaoComentario> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }
}
