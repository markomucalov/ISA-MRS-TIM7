package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PozoristeRep;

@Service
public class PozoristeServiceImpl implements PozoristeService {

	@Autowired
	private PozoristeRep pozoristeRep;
	
	@Override
	public Page<Pozoriste> getAllPozorista(Pageable pageable) {
		
		return pozoristeRep.findAll(pageable);
	}
	
	

}
