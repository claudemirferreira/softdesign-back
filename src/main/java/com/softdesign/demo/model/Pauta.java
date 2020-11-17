package com.softdesign.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta {

	@Id
	@Column(name = "id_pauta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, length = 100)
	private String nome;

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

	public Pauta() {
	}
	
	public Pauta(Integer id) {
		this.id = id;
	}

	public Pauta(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

}
