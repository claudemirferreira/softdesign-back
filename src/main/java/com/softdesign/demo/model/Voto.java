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

	@ManyToOne
	@JoinColumn(name = "id_associado")
	// @JsonIgnore
	private Associado associado;

	@ManyToOne
	@JoinColumn(name = "id_sessao")
	// @JsonIgnore
	private Sessao sessao;
	
	private String resultado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Voto(Integer id, Associado associado, Sessao sessao, String resultado) {
		this.id = id;
		this.associado = associado;
		this.sessao = sessao;
		this.resultado = resultado;
	}

}
