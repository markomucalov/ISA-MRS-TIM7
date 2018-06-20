package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.TerminPredstaveProjekcijeRep;

@Service
public class TerminPredstaveProjekcijeServiceImpl implements TerminPredstaveProjekcijeService {

	@Autowired
	private TerminPredstaveProjekcijeRep terminRep;

	@Override
	public List<TerminPredstaveProjekcije> findAllBySalaAndDatum(Sala sala, Date datum) {
		return terminRep.findAllBySalaAndDatum(sala, datum);
	}

	@Override
	public void save(TerminPredstaveProjekcije termin) {
		terminRep.save(termin);		
	}

	@Override
	public TerminPredstaveProjekcije findBySalaAndDatumAndPocetak(Sala sala, Date datum, Time pocetak) {
		return terminRep.findBySalaAndDatumAndPocetak(sala, datum, pocetak);
	}
	
	@Override
	public List<TerminPredstaveProjekcije> findAll() {
		
		return terminRep.findAll();
	}

	@Override
	public TerminPredstaveProjekcije findById(Long id) {
		// TODO Auto-generated method stub
		return terminRep.findById(id);
	}
	
	
}
