package com.softdesign.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softdesign.demo.model.Associado;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.model.Voto;
import com.softdesign.demo.repository.VotoRepository;

@SpringBootTest
class VotoRepositoryTest {

	@Autowired
	private VotoRepository rep;

	//@Test
	void insert() {
		//rep.save(new Voto(null, new Associado(1), new Sessao(1), "S"));
	}
	

	@Test
	void inset() {
		List<Voto> lista = rep.listaVotos(new Associado(1), new Sessao(1));
		if (null == lista)
			System.out.println("false");
		else 
			System.out.println("true");
	}

}
