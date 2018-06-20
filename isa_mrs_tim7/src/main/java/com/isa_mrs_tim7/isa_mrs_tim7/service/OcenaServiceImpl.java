package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Ocena;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.OcenaRep;

@Service
public class OcenaServiceImpl implements OcenaService{

	@Autowired
	OcenaRep ocenaRep;
	
	@Override
	public Ocena findByBioskopAndFilmAndDatumAndRedAndKolona(Bioskop bioskop, Film film, Date datum, Integer red,
			Integer kolona) {
		
		return ocenaRep.findByBioskopAndFilmAndDatumAndRedAndKolona(bioskop, film, datum, red, kolona);
	}

	@Override
	public Ocena findByPozoristeAndPredstavaAndDatumAndRedAndKolona(Pozoriste pozoriste, Predstava predstava,
			Date datum, Integer red, Integer kolona) {
		
		return ocenaRep.findByPozoristeAndPredstavaAndDatumAndRedAndKolona(pozoriste, predstava, datum, red, kolona);
	}

	@Override
	public void save(Ocena ocena) {
		ocenaRep.save(ocena);
		
	}

	
}
