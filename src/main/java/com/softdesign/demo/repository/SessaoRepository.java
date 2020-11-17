package com.softdesign.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdesign.demo.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

}
