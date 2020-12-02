package com.softdesign.demo.controllers;

import com.softdesign.demo.base.core.controller.BaseRestController;
import com.softdesign.demo.base.core.service.BaseService;

import com.softdesign.demo.controllers.dto.SessaoDTO;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.service.impl.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2/sessao")
public class SessaoController extends BaseRestController<SessaoDTO, Sessao, SessaoService> {

    @Autowired
    private SessaoService sessaoService;


}
