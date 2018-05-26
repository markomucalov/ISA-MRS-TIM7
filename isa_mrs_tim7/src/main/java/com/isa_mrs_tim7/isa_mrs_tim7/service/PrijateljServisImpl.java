package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Prijatelj;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PrijateljRep;

@Service
public class PrijateljServisImpl implements PrijateljServis {
	@Autowired
	private PrijateljRep prijateljRep;
	
	
	@Override
	public Prijatelj dodaj(Prijatelj prijatelj) {
		Assert.notNull(prijatelj.getPoslao(), "Posiljalac ne sme biti null");
		Assert.notNull(prijatelj.getPrihvatio(), "Prihvatac ne sme biti null");
		Assert.notNull(prijatelj.getOpcija(), "Opcija ne sme biti null");
		System.out.println(prijatelj.getPoslao());
		Optional <Prijatelj> pronadjena = this.prijateljRep.findByPoslaoAndPrihvatio(prijatelj.getPoslao(),prijatelj.getPrihvatio());
		
		if(!pronadjena.isPresent()){
			this.prijateljRep.save(prijatelj);
			return prijatelj;
		}
		
		
		
		return null;
	}

	@Override
	public Prijatelj obrisi(Prijatelj prijatelj) {
		Assert.notNull(prijatelj.getPoslao(), "Posiljalac ne sme biti null");
		Assert.notNull(prijatelj.getPrihvatio(), "Prihvatac ne sme biti null");
		
     Optional <Prijatelj> pronadjena = this.prijateljRep.findByPoslaoAndPrihvatio(prijatelj.getPoslao(),prijatelj.getPrihvatio());
        prijatelj.setId(pronadjena.get().getId());
		if(pronadjena.isPresent()){
			return this.prijateljRep.delete(prijatelj);
		}
		
		
		
		return null;
		
		
		
	}

	@Override
	public Prijatelj update(Prijatelj prijatelj) {
		
	Assert.notNull(prijatelj.getPoslao(), "Posiljalac ne sme biti null");
	Assert.notNull(prijatelj.getPrihvatio(), "Prihvatac ne sme biti null");
    Optional <Prijatelj> pronadjena = this.prijateljRep.findByPoslaoAndPrihvatio(prijatelj.getPoslao(),prijatelj.getPrihvatio());
		prijatelj.setId(pronadjena.get().getId());
		if(pronadjena.isPresent()){
			return this.prijateljRep.save(prijatelj);
		}
		
		
		
		return null;
	}
	
	
	

}
