package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipKarte;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.KartaRep;

@Service
@Transactional(readOnly = true)
public class KartaServiceImpl implements KartaService {

	@Autowired
	private KartaRep kartaRep;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Karta karta) {
		kartaRep.save(karta);
	}

	@Override
	public List<Karta> getKartaByTipKarte(TipKarte tipKarte) {
		return kartaRep.getKartaByTipKarte(tipKarte);
	}

	@Override
	public Karta findByRedAndKolonaAndTerminPredstaveProjekcije(Integer red, Integer kolona,
			TerminPredstaveProjekcije termin) {
		return kartaRep.findByRedAndKolonaAndTerminPredstaveProjekcije(red, kolona, termin);
	}

	@Override
	public Karta findById(long id) {
		return kartaRep.findById(id).get();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void update(Karta karta, RegistrovaniKorisnik regKorisnik) throws Exception{
		
		Karta kartaToUpdate = findById(karta.getId());
		kartaToUpdate.setRegistrovaniKorisnik(regKorisnik);
		save(kartaToUpdate);
	}
	
	
}
