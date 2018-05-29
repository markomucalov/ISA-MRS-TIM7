package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sediste;

public interface SedisteService {

	void save(Sediste sediste);
	
	List<Sediste> findBySala(Sala sala);
}
