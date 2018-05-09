package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.AdresaRep;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PozoristeRep;

@Service
public class PozoristeServiceImpl implements PozoristeService {

	@Autowired
	private PozoristeRep pozoristeRep;
	
	@Autowired
	private AdresaRep adresaRep;
	
	@Override
	public Page<Pozoriste> getAllPozorista(Pageable pageable) {
		
		return pozoristeRep.findAll(pageable);
	}

	@Override
	public Pozoriste unesiPozoriste(Pozoriste pozoriste) {
		
		System.out.println(pozoriste.getNaziv());
		Optional <Adresa> pronadjenaAdresa = this.adresaRep.findByUlicaAndBrojAndGrad(pozoriste.getAdresa().getUlica(), pozoriste.getAdresa().getBroj(), pozoriste.getAdresa().getGrad());
		System.out.println(pozoriste.getAdresa());
		if(!pronadjenaAdresa.isPresent()){
			this.adresaRep.save(pozoriste.getAdresa());
			return this.pozoristeRep.save(pozoriste);
		}
		
		return null;
		
	}

	@Override
	public void obrisiPozoriste(Pozoriste pozoriste) {
		this.pozoristeRep.delete(pozoriste);
	}
	
	

}
