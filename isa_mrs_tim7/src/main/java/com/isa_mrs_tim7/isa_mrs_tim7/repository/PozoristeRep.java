package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;

public interface PozoristeRep extends Repository<Pozoriste, Long> {
	Pozoriste findOneByNaziv(String naziv);
	Page<Pozoriste> findAll(Pageable pageable);	
	Pozoriste findByNaziv(String nazivPozorista);	
	Pozoriste findByAdresa(Adresa adresa);	
	Pozoriste save(Pozoriste pozoriste);
}
