package com.softdesign.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softdesign.demo.model.Pauta;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.repository.SessaoRepository;

@SpringBootTest
class SessaoRepositoryTest {

	@Autowired
	private SessaoRepository rep;

	@Test
	void inset() {
//		rep.save(new Sessao(null, "11", new Pauta(null, )));
	}

}
