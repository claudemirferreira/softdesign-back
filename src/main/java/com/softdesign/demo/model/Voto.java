package com.softdesign.demo.model;

import com.softdesign.demo.base.core.model.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Voto extends AbstractModel {

	@ManyToOne
	@JoinColumn(name = "id_associado")
	// @JsonIgnore
	private Associado associado;

	@ManyToOne
	@JoinColumn(name = "id_sessao")
	// @JsonIgnore
	private Sessao sessao;
	
	private String resultado;

}
