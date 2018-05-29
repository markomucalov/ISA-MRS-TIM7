package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sediste;

public interface SedisteRep extends Repository<Sediste, Long> {

	void save(Sediste sediste);
	
	List<Sediste> findBySala(Sala sala);
}
