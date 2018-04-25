package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.AdresaRep;

@Service
public class AdresaServiceImpl implements AdresaService {
	
	@Autowired
	private AdresaRep adresaRep;

	@Override
	public Adresa getAdresa(Long id) {
		
		return adresaRep.findById(id);
	}

}
