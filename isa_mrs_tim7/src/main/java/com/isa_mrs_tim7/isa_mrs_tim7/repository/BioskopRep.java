package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;

public interface BioskopRep extends CrudRepository<Bioskop, Long> {

	Page<Bioskop> findAll(Pageable pageable);

	Bioskop findByNaziv(String nazivBioskopa);
	
	Bioskop findByAdresa(Adresa adresa);

	Bioskop save(Bioskop bioskop);
}
