package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;

public interface AdresaRep extends Repository<Adresa, Long> {

	Adresa findById(Long id);

	Optional<Adresa> findByUlicaAndBrojAndGrad(String ulica, Integer broj, String grad);

	Adresa save(Adresa adresa);

}
