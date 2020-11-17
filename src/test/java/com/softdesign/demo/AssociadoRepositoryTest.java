package com.softdesign.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softdesign.demo.model.Associado;
import com.softdesign.demo.repository.AssociadoRepository;

@SpringBootTest
class AssociadoRepositoryTest {

	@Autowired
	private AssociadoRepository rep;

	@Test
	void inset() {
		rep.save(new Associado(null, "Associado 1", "12345678901"));
	}

}
