package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipKarte;

public interface KartaRep extends Repository<Karta, Long>{

	void save(Karta Karta);
	
	List<Karta> getKartaByTipKarte(TipKarte tipKarte);
}
