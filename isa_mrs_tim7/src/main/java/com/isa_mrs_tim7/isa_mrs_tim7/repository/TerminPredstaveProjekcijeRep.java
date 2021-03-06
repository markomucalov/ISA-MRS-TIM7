package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;

public interface TerminPredstaveProjekcijeRep extends Repository<TerminPredstaveProjekcije, Long>{

	List<TerminPredstaveProjekcije> findAllBySalaAndDatum(Sala sala, Date datum);
	
	void save(TerminPredstaveProjekcije termin);
	
	TerminPredstaveProjekcije findBySalaAndDatumAndPocetak(Sala sala, Date datum, Time pocetak);
	
	
	
	 List<TerminPredstaveProjekcije> findAll();
	 TerminPredstaveProjekcije findById(Long id);
}
