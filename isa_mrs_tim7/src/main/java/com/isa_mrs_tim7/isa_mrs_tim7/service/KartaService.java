package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipKarte;

public interface KartaService {
	
	void save(Karta karta);

	List<Karta> getKartaByTipKarte(TipKarte tipKarte);
}
