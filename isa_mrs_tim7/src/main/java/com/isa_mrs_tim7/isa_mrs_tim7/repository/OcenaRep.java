package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import java.sql.Date;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Ocena;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;

public interface OcenaRep extends Repository<Ocena, Long>{

	Ocena findByBioskopAndFilmAndDatumAndRedAndKolona(Bioskop bioskop,Film film, Date datum, Integer red, Integer kolona);
	Ocena findByPozoristeAndPredstavaAndDatumAndRedAndKolona(Pozoriste pozoriste,Predstava predstava, Date datum, Integer red, Integer kolona);
	void save(Ocena ocena);
}
