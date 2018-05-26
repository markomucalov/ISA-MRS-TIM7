package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Prijatelj;



public interface PrijateljRep extends Repository<Prijatelj, Long> {
	Optional<Prijatelj> findById(Long id);
	
	List<Prijatelj> findByOpcija(int opcija);
	List<Prijatelj> findByPrihvatioAndOpcija(String prihvatio,int opcija);
	Optional<Prijatelj> findByPoslaoAndPrihvatio(String email1,String email2);
	Prijatelj save(Prijatelj reg);
	Prijatelj delete(Prijatelj reg);
	
}
