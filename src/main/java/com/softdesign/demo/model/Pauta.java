package com.softdesign.demo.model;

import com.softdesign.demo.base.core.model.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Pauta extends AbstractModel {

	@Column(unique = true, length = 100)
	private String nome;

	public Pauta() {
	}

	public Pauta(UUID id, String nome) {
		this.nome = nome;
	}
}
