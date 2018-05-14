package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PozoristeRep;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PredstavaRep;

@Service
public class PozoristeServiceImpl implements PozoristeService {

	@Autowired
	private PozoristeRep pozoristeRep;
	
	@Autowired
	private PredstavaRep predstavaRep;
	
	@Override
	public Page<Pozoriste> getAllPozorista(Pageable pageable) {
		
		return pozoristeRep.findAll(pageable);
	}
	
	@Override
	public Pozoriste findByNaziv(String naziv) {
		return pozoristeRep.findOneByNaziv(naziv);
	}
	
	@Override
	public Page<Predstava> getPredstave(Pozoriste pozoriste, Pageable pageable) {
		Assert.notNull(pozoriste, "Pozoriste ne sme biti null");
		return predstavaRep.findByPozoriste(pozoriste, pageable);
	}
	
	@Override
	public Pozoriste save(Pozoriste pozoriste) {
		return pozoristeRep.save(pozoriste);
	}

}
