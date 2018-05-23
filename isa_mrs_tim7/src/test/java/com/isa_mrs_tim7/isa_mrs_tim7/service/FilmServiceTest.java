package com.isa_mrs_tim7.isa_mrs_tim7.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.isa_mrs_tim7.isa_mrs_tim7.constants.FilmConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmServiceTest {
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	BioskopService bioskopService;

	@Test
    @Transactional
    @Rollback(true)
	public void testSave() throws ParseException {
		Bioskop bioskop = bioskopService.findByNaziv("Roda Cineplexx");
		Film film = new Film();
		film.setBioskop(bioskop);
		film.setCena(FilmConstants.CENA);
		film.setImeReditelja(FilmConstants.IME_REDITELJA);
		film.setNaizv(FilmConstants.NAZIV);
		
		List<Integer> ocene = new ArrayList<Integer>();
		film.setOcene(ocene);
		film.setOpis(FilmConstants.OPIS);
		film.setSlika(FilmConstants.SLIKA);
		
		List<String> spisakGlumaca = new ArrayList<String>();
		
		spisakGlumaca.add(FilmConstants.PRVI_GLUMAC);
		spisakGlumaca.add(FilmConstants.DRUGI_GLUMAC);
		
		film.setSpisakGlumaca(spisakGlumaca);
		
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    long timeLong = sdf.parse(FilmConstants.TRAJANJE).getTime();
	    Time time = new Time(timeLong);
		film.setTrajanje(time);
		film.setZanr(FilmConstants.ZANR);
		
		Integer dbSizeBefore = bioskopService.getAllFilmovi(bioskop).size();
		
		filmService.save(film);
		
		List<Film> filmovi = bioskopService.getAllFilmovi(bioskop);
		
		assertThat(filmovi).hasSize(dbSizeBefore + 1);
		
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testDelete() {
		
		Bioskop bioskop = bioskopService.findByNaziv("Roda Cineplexx");
		
		Film film = filmService.findFilmByNaizvAndBioskop("Film test", bioskop);
		
		Integer dbSizeBefore = bioskopService.getAllFilmovi(bioskop).size();
		
		filmService.delete(film);
		
		List<Film> filmovi = bioskopService.getAllFilmovi(bioskop);
		
		assertThat(filmovi).hasSize(dbSizeBefore - 1);
	}
	
	@Test
	public void testFindByNazivAndBioskop() {
		Bioskop bioskop = bioskopService.findByNaziv("Roda Cineplexx");
		Film film = filmService.findFilmByNaizvAndBioskop("Film test", bioskop);
		assertThat(film.getNaizv()).isEqualTo("Film test");
		assertThat(film.getCena()).isEqualTo(500);
		assertThat(film.getImeReditelja()).isEqualTo("Reditelj Rediteljevic");
		assertThat(film.getOpis()).isEqualTo("Neki opis");		
	}
}
