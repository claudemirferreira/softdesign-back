package com.softdesign.demo.service.impl;

import com.softdesign.demo.base.core.mapper.BaseMapperFactory;
import com.softdesign.demo.base.core.repository.BaseRepository;
import com.softdesign.demo.base.core.service.BaseService;
import com.softdesign.demo.controllers.dto.SessaoDTO;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoService extends BaseService<Sessao> {

    @Autowired
    private SessaoRepository repository;

    @Autowired
    private SessaoService sessaoService;

    @Override
    protected BaseRepository<Sessao> getRepository() {
        return repository;
    }

    public Sessao saveSessao(SessaoDTO sessaoDto) {
        final Sessao sessao = BaseMapperFactory.getMapper(SessaoDTO.class, Sessao.class).map(sessaoDto);
        return repository.save(sessao);
    }
}
