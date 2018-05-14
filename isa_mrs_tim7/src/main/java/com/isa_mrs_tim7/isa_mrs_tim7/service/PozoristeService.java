package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;

public interface PozoristeService {
	
	Page<Pozoriste> getAllPozorista(Pageable pageable);
	Pozoriste findByNaziv(String naziv);
	Page<Predstava> getPredstave(Pozoriste pozoriste, Pageable pageable);
	Pozoriste save(Pozoriste pozoriste);
}
