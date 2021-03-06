package com.isa_mrs_tim7.isa_mrs_tim7.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.PAGE_SIZE;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioskopServiceTest {
	
	@Autowired
	BioskopService bioskopService;
	
	@Test
	public void testGetAllBioskopi() {
		PageRequest pageRequest = PageRequest.of(0, PAGE_SIZE); //second page
		Page<Bioskop> bioskopi = bioskopService.getAllBioskopi(pageRequest);
		assertThat(bioskopi).hasSize(PAGE_SIZE); 
	}
	
	@Test
	public void testFindByNaziv() {
		String naziv = "CineStar Zrenjanin";
		Bioskop bioskop = bioskopService.findByNaziv(naziv);
		assertThat(bioskop).hasFieldOrPropertyWithValue("naziv", "CineStar Zrenjanin");
		assertThat(bioskop).hasFieldOrPropertyWithValue("rejting", 5);
	}
	
	@Test
	public void testGetFilmovi() {
		PageRequest pageRequest = PageRequest.of(0, 4);
		String naziv = "CineStar Zrenjanin";
		Bioskop bioskop = bioskopService.findByNaziv(naziv);
		Page<Film> filmovi = bioskopService.getFilmovi(bioskop, pageRequest);
		assertThat(filmovi).hasSize(4);
	}

}
