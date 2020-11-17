package com.softdesign.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softdesign.demo.model.Associado;
import com.softdesign.demo.model.Sessao;
import com.softdesign.demo.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Integer> {

	@Query("select a from Voto a where a.associado.id = :associado.id and a.sessao.id = :sessao.id")
	List<Voto> listaVotos(@Param("associado") Associado associado, @Param("sessao") Sessao sessao);

}
