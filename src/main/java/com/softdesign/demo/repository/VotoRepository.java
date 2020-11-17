package com.softdesign.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdesign.demo.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Integer> {

}
