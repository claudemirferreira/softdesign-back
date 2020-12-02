package com.softdesign.demo.model;

import com.softdesign.demo.base.core.model.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Sessao extends AbstractModel {

	@Column(unique = true, length = 100)
	private String nome;

}
