package com.softdesign.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.demo.model.Associado;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.model.Voto;
import com.softdesign.demo.repository.VotoRepository;
import com.softdesign.demo.service.VotoService;

@Service
public class VotoServiceImpl implements VotoService {

	@Autowired
	private VotoRepository rep;

	@Override
	public Boolean existeVoto(Associado associado, Sessao sessao) {
		List<Voto> lista = rep.listaVotos(associado, sessao);
		System.out.println("########################=" + lista.size());
		if (lista.size() > 0)
			return true;
		else
			return false;
	}

}
