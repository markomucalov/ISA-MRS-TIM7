package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;

public interface BioskopService {

	Page<Bioskop> getAllBioskopi(Pageable pageable);
	
	Bioskop findByNaziv(String naziv);
	
	Page<Film> getFilmovi(Bioskop bioskop, Pageable pageable);
	
	List<Film> getAllFilmovi(Bioskop bioskop);
	Bioskop save(Bioskop bioskop);

	Bioskop unesiBioskop(Bioskop bioskop);

	void obrisiBioskop(Bioskop bioskop);
}
