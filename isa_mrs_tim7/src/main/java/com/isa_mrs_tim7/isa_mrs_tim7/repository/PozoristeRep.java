package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;

public interface PozoristeRep extends CrudRepository<Pozoriste, Long> {

	Page<Pozoriste> findAll(Pageable pageable);
	
	Pozoriste findByNaziv(String nazivPozorista);
	
	Pozoriste findByAdresa(Adresa adresa);
	
	Pozoriste save(Pozoriste pozoriste);

}
