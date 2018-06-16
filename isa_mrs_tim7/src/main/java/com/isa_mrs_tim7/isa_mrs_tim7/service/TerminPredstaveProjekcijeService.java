package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.sql.Date;
import java.util.List;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;

public interface TerminPredstaveProjekcijeService {

	List<TerminPredstaveProjekcije> findAllBySalaAndDatum(Sala sala, Date datum);
	
	void save(TerminPredstaveProjekcije termin);
}