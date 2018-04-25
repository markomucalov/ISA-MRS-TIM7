package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;

public interface AdresaRep extends Repository<Adresa, Long> {
	
	Adresa findById(Long id);

}
