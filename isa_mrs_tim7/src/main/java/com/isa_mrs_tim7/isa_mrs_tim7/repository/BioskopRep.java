package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;


public interface BioskopRep extends Repository<Bioskop, Long> {
	
	Page<Bioskop> findAll(Pageable pageable);
	Bioskop findOneByNaziv(String naziv);
	Bioskop findByNaziv(String nazivBioskopa);
	Bioskop findByAdresa(Adresa adresa);
	Bioskop save(Bioskop bioskop);
}
