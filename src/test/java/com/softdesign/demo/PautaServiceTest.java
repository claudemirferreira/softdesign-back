package com.softdesign.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softdesign.demo.model.Pauta;
import com.softdesign.demo.service.PautaService;

@SpringBootTest
class PautaServiceTest {

	@Autowired
	private PautaService service;

	@Test
	void insert() {
		service.save(new Pauta(null, "Teste4"));
	}

}
