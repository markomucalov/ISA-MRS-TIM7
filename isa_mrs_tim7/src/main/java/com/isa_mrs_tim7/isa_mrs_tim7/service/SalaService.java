package com.isa_mrs_tim7.isa_mrs_tim7.service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;

public interface SalaService {
	
	void save(Sala sala);
	
	Sala findByNaziv(String naziv);
	
	Sala findByNazivAndBioskop(String naziv, Bioskop bioskop);
	
	Sala findByNazivAndPozoriste(String naziv, Pozoriste pozoriste);

}
