package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;

public interface KartaRep extends Repository<Karta, Long>{

	void save(Karta Karta);
}
