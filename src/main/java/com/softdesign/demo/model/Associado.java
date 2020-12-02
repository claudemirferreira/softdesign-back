package com.softdesign.demo.model;

import com.softdesign.demo.base.core.model.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Associado extends AbstractModel {

	@Column(unique = true, length = 100)
	private String nome;

	@Column(unique = true, length = 11)
	private String cpf;

}
