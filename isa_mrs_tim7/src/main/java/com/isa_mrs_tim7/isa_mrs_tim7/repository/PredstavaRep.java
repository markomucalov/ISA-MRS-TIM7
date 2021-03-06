package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;

public interface PredstavaRep extends Repository<Predstava, Long> {

	Page<Predstava> findByPozoriste(Pozoriste pozoriste, Pageable pageable);
	
	List<Predstava> findPredstaveByPozoriste(Pozoriste pozoriste);
	
	void save(Predstava predstava);
	
	Predstava findPredstavaByNaizvAndPozoriste(String naizv, Pozoriste pozoriste);
	
	void delete(Predstava predstava);
}
