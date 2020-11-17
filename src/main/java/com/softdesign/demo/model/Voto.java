package com.softdesign.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voto {

	@Id
	@Column(name = "id_voto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_associado")
	// @JsonIgnore
	private Associado associado;

	@ManyToOne
	@JoinColumn(name = "id_sessao")
	// @JsonIgnore
	private Sessao sessao;
	
	private Integer resultado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	public Voto(Integer id, String nome, Associado associado, Sessao sessao, Integer resultado) {
		this.id = id;
		this.nome = nome;
		this.associado = associado;
		this.sessao = sessao;
		this.resultado = resultado;
	}

}
