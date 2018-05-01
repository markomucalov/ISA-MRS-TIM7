package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;

public interface BioskopService {
	
	Page<Bioskop> getAllBioskopi(Pageable pageable);

}
