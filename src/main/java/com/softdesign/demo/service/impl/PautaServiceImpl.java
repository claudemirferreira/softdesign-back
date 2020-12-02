package com.softdesign.demo.service.impl;

import com.softdesign.demo.base.core.repository.BaseRepository;
import com.softdesign.demo.base.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesign.demo.model.Pauta;
import com.softdesign.demo.repository.PautaRepository;
import com.softdesign.demo.service.PautaService;

@Service
public class PautaServiceImpl extends BaseService<Pauta> {

	@Autowired
	private PautaRepository repository;

	public Pauta save(Pauta pauta) {
		return repository.save(pauta);
	}

	@Override
	protected BaseRepository<Pauta> getRepository() {
		return repository;
	}

}
