package com.softdesign.demo.service.impl;

import com.softdesign.demo.base.core.repository.BaseRepository;
import com.softdesign.demo.base.core.service.BaseService;
import com.softdesign.demo.model.Associado;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.model.Voto;
import com.softdesign.demo.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoServiceImpl extends BaseService {

	@Autowired
	private VotoRepository repository;

	@Override
	protected BaseRepository getRepository() {
		return this.repository;
	}

	public Boolean existeVoto(Associado associado, Sessao sessao) {
		List<Voto> lista = repository.listaVotos(associado, sessao);
		System.out.println("########################=" + lista.size());
		if (lista.size() > 0)
			return true;
		else
			return false;
	}

}
