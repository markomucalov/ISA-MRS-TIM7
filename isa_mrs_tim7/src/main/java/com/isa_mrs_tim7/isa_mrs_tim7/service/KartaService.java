package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipKarte;

public interface KartaService {
	
	void save(Karta karta);

	List<Karta> getKartaByTipKarte(TipKarte tipKarte);
	
	Karta findByRedAndKolonaAndTerminPredstaveProjekcije(Integer red, Integer kolona, TerminPredstaveProjekcije termin);

	Karta findById(long id);
	
	void update(Karta karta, RegistrovaniKorisnik regKorisnik) throws Exception;
}
