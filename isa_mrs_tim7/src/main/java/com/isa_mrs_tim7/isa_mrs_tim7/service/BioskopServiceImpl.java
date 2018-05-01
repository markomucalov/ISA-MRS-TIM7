package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.BioskopRep;

@Service
public class BioskopServiceImpl implements BioskopService {

	@Autowired
	private BioskopRep bioskopRep;
	
	@Override
	public Page<Bioskop> getAllBioskopi(Pageable pageable) {
		
		return bioskopRep.findAll(pageable);
	}
}
