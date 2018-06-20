package com.isa_mrs_tim7.isa_mrs_tim7.service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;

public interface PredstavaService {

	void save(Predstava predstava);
	
	Predstava findPredstavaByNaizvAndPozoriste(String naizv, Pozoriste pozoriste);
	
	void delete(Predstava predstava);
}
