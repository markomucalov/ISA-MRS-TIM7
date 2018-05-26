package com.isa_mrs_tim7.isa_mrs_tim7.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;


import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;












public interface RegistrovaniKorisnikRep extends Repository<RegistrovaniKorisnik, Long> {
	RegistrovaniKorisnik findByEmailAndLozinka(String email1, String lozinka1);
	Optional<RegistrovaniKorisnik> findByEmail(String email);
	Page<RegistrovaniKorisnik> findAll(Pageable page);
	RegistrovaniKorisnik save(RegistrovaniKorisnik reg);
	RegistrovaniKorisnik delete(RegistrovaniKorisnik reg);
	RegistrovaniKorisnik findById(String id);
	
	
}