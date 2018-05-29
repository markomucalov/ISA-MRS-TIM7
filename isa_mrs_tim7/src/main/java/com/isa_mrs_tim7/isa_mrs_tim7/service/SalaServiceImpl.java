package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.SalaRep;

@Service
public class SalaServiceImpl implements SalaService {
	
	@Autowired
	private SalaRep salaRep;
	
	@Override
	public void save(Sala sala) {
		salaRep.save(sala);
	}
	
	@Override
	public Sala findByNaziv(String naziv) {
		return salaRep.findByNaziv(naziv);
	}
	
	@Override
	public Sala findByNazivAndBioskop(String naziv, Bioskop bioskop) {
		return salaRep.findByNazivAndBioskop(naziv, bioskop);
	}
	
	@Override
	public Sala findByNazivAndPozoriste(String naziv, Pozoriste pozoriste) {
		return salaRep.findByNazivAndPozoriste(naziv, pozoriste);
	}

}
