package com.isa_mrs_tim7.isa_mrs_tim7.service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;

public interface FilmService {
	
	void save(Film film);
	
	void delete(Film film);
	
	Film findFilmByNaizvAndBioskop(String naizv, Bioskop bioskop);

}
