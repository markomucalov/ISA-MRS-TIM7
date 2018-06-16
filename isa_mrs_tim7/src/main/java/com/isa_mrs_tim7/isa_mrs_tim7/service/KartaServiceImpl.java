package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.KartaRep;

@Service
public class KartaServiceImpl implements KartaService {

	@Autowired
	private KartaRep kartaRep;
	
	@Override
	public void save(Karta karta) {
		kartaRep.save(karta);
	}
}
