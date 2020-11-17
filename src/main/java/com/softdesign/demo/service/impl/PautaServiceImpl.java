package com.softdesign.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softdesign.demo.model.Pauta;
import com.softdesign.demo.repository.PautaRepository;
import com.softdesign.demo.service.PautaService;

public class PautaServiceImpl implements PautaService {

	@Autowired
	private PautaRepository rep;

	@Override
	public Pauta save(Pauta pauta) {
		return rep.save(pauta);
	}

}
