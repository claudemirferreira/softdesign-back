package com.softdesign.demo.service;

import com.softdesign.demo.model.Associado;
import com.softdesign.demo.model.Sessao;

public interface VotoService {

	public Boolean existeVoto(Associado associado, Sessao sessao);

}
