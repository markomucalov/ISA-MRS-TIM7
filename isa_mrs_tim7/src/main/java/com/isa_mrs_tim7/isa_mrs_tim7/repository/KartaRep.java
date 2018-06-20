package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipKarte;

public interface KartaRep extends JpaRepository<Karta, Long>{

	//void save(Karta Karta);
	
	List<Karta> getKartaByTipKarte(TipKarte tipKarte);
	
	List<Karta> getKartaByRegistrovaniKorisnik(RegistrovaniKorisnik regKorisnik);
	
	Karta findByRedAndKolonaAndTerminPredstaveProjekcije(Integer red, Integer kolona, TerminPredstaveProjekcije termin);

	//Karta findById(Long id);
}
