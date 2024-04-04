package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AvaliacaoComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int classificacao; // A classificação pode ser um número de 1 a 5, por exemplo
    
    private String comentario;

    public AvaliacaoComentario() {
    }

    public AvaliacaoComentario(int classificacao, String comentario) {
        this.setClassificacao(classificacao);
        this.setComentario(comentario);
    }

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	}
