package com.softdesign.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softdesign.demo.model.Pauta;
import com.softdesign.demo.repository.PautaRepository;

@SpringBootTest
class PautaRepositoryTest {

	@Autowired
	private PautaRepository rep;

	@Test
	void inset() {
		rep.save(new Pauta(null, "Teste2"));
	}

}
