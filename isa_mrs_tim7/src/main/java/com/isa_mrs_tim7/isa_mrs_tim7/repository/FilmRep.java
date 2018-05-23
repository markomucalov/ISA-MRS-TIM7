package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;

public interface FilmRep extends Repository<Film, Long> {

	Page<Film> findByBioskop(Bioskop bioskop, Pageable pageable);
	
	List<Film> findFilmoviByBioskop(Bioskop bioskop);
	
	void save(Film film);
	
	Film findFilmByNaizvAndBioskop(String naizv, Bioskop bioskop);
	
	void delete(Film film);
}
