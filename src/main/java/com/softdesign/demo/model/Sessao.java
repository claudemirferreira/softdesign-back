package com.softdesign.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {

	@Id
	@Column(name = "id_sessao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, length = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_pauta")
	// @JsonIgnore
	private Pauta pauta;

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

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Sessao() {
	}

	public Sessao(Integer id) {
		this.id = id;
	}

	public Sessao(Integer id, String nome, Pauta pauta) {
		this.id = id;
		this.nome = nome;
		this.pauta = pauta;
	}

}
