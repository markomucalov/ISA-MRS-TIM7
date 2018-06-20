package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PredstavaRep;

@Service
public class PredstavaServiceImpl implements PredstavaService{
	
	@Autowired
	PredstavaRep predstavaRep;

	@Override
	public void save(Predstava predstava) {
		predstavaRep.save(predstava);		
	}

	@Override
	public Predstava findPredstavaByNaizvAndPozoriste(String naizv, Pozoriste pozoriste) {
		return predstavaRep.findPredstavaByNaizvAndPozoriste(naizv, pozoriste);
	}

	@Override
	public void delete(Predstava predstava) {
		predstavaRep.delete(predstava);		
	}

}
