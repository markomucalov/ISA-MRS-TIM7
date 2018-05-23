package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.FilmRep;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	FilmRep filmRep;
	
	@Override
	public void save(Film film) {
		filmRep.save(film);
	}
	
	@Override
	public void delete(Film film) {
		filmRep.delete(film);
	}
	
	@Override
	public Film findFilmByNaizvAndBioskop(String naizv, Bioskop bioskop) {
		return filmRep.findFilmByNaizvAndBioskop(naizv, bioskop);
	}

}
