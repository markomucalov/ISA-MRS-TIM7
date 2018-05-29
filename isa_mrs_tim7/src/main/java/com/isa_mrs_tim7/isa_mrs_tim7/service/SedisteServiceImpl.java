package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sediste;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.SedisteRep;

@Service
public class SedisteServiceImpl implements SedisteService{
	
	@Autowired
	private SedisteRep sedisteRep;
	
	@Override
	public void save(Sediste sediste) {
		sedisteRep.save(sediste);
	}
	
	@Override
	public List<Sediste> findBySala(Sala sala){
		return sedisteRep.findBySala(sala);
	}

}
