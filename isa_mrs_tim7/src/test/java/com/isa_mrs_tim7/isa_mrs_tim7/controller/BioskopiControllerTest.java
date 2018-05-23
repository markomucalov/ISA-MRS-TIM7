package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.DB_ADRESA_BROJ;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.DB_ADRESA_GRAD;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.DB_ADRESA_ULICA;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.DB_ADRESA_ZIP;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.DB_NAZIV;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.DB_REJTING;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants.PAGE_SIZE;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.isa_mrs_tim7.isa_mrs_tim7.TestUtil;
import com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.constants.FilmConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;
import com.isa_mrs_tim7.isa_mrs_tim7.service.BioskopService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.FilmService;

@RunWith(SpringRunner.class)
@SpringBootTest 
public class BioskopiControllerTest {
	
	private static final String URL_PREFIX = "/bioskopi";
	private static final String URL_DODAVANJE = "/kreiranjeBioskopa";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	BioskopService bioskopService;

	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetBioskopiPage() throws Exception {
		mockMvc.perform(get(URL_PREFIX+"?page=0&size=" + PAGE_SIZE)).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.content", hasSize(PAGE_SIZE)))
				.andExpect(jsonPath("$.content[0].naziv").value(DB_NAZIV))
				.andExpect(jsonPath("$.content[0].rejting").value(DB_REJTING))
				.andExpect(jsonPath("$.content[0].adresa.ulica").value(DB_ADRESA_ULICA))
				.andExpect(jsonPath("$.content[0].adresa.broj").value(DB_ADRESA_BROJ))
				.andExpect(jsonPath("$.content[0].adresa.grad").value(DB_ADRESA_GRAD))
				.andExpect(jsonPath("$.content[0].adresa.zip").value(DB_ADRESA_ZIP));
	}
	
	@Test
	public void testGetBioskop() throws Exception {
		mockMvc.perform(get("/CineStar Zrenjanin/bioskop")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.naziv").value(DB_NAZIV))
				.andExpect(jsonPath("$.rejting").value(DB_REJTING))
				.andExpect(jsonPath("$.adresa.ulica").value(DB_ADRESA_ULICA))
				.andExpect(jsonPath("$.adresa.broj").value(DB_ADRESA_BROJ))
				.andExpect(jsonPath("$.adresa.grad").value(DB_ADRESA_GRAD))
				.andExpect(jsonPath("$.adresa.zip").value(DB_ADRESA_ZIP));
	}
	
	@Test
	public void testGetFilmoviPage() throws Exception {
		mockMvc.perform(get("/CineStar Zrenjanin/filmovi/0")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.content", hasSize(4)))
				.andExpect(jsonPath("$.content[0].naizv").value("Ko to tamo peva"))
				.andExpect(jsonPath("$.content[0].zanr").value("komedija"))
				.andExpect(jsonPath("$.content[0].imeReditelja").value("Slobodan Sijan"));
	}
	
	@Test
	public void testGetAllFilmovi() throws Exception{
		mockMvc.perform(get("/CineStar Zrenjanin/allFilmovi")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].naizv").value("Ko to tamo peva"))
		.andExpect(jsonPath("$[0].zanr").value("komedija"))
		.andExpect(jsonPath("$[0].imeReditelja").value("Slobodan Sijan"));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddFilm() throws Exception{
		Bioskop bioskop = new Bioskop();
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
		
		String json = TestUtil.json(bioskop);
		this.mockMvc.perform(post("/Takvud Cineplexx/dodajFilm").contentType(contentType).content(json)).andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteFilm() throws Exception{
		Bioskop bioskop = bioskopService.findByNaziv(FilmConstants.BIOSKOP_NAZIV_DELETE);
		Film film = filmService.findFilmByNaizvAndBioskop(FilmConstants.FILM_NAZIV_DELETE, bioskop);
		
		String json = TestUtil.json(film);
		
		this.mockMvc.perform(post("/"+FilmConstants.BIOSKOP_NAZIV_DELETE+"/"+FilmConstants.FILM_NAZIV_DELETE+"/obrisiFilm").contentType(contentType).content(json)).andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateBioskop() throws Exception {
		Bioskop bioskop = new Bioskop();
		Adresa adresa = new Adresa();
		bioskop.setNaziv(BioskopConstants.DB_NAZIV_UPDATE);
		bioskop.setPromotivniOpis(BioskopConstants.DB_PROMOTIVNI_OPIS_UPDATE);
		adresa.setBroj(BioskopConstants.DB_ADRESA_BROJ_UPDATE);
		adresa.setUlica(BioskopConstants.DB_ADRESA_ULICA_UPDATE);
		adresa.setGrad(BioskopConstants.DB_ADRESA_GRAD_UPDATE);
		adresa.setZip(BioskopConstants.DB_ADRESA_ZIP_UPDATE);
		bioskop.setAdresa(adresa);

		String json = TestUtil.json(bioskop);
		this.mockMvc.perform(post("/Takvud Cineplexx/izmenaPodataka").contentType(contentType).content(json)).andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDodavanjeBioskopa() throws Exception {
		Bioskop bioskop = new Bioskop();
		bioskop.setNaziv(BioskopConstants.DB_NAZIV_INSERT);
		bioskop.setRejting(BioskopConstants.DB_REJTING_INSERT);
		Adresa adresa = new Adresa();
		adresa.setBroj(BioskopConstants.DB_ADRESA_BROJ_INSERT);
		adresa.setGrad(BioskopConstants.DB_ADRESA_GRAD_INSERT);
		adresa.setUlica(BioskopConstants.DB_ADRESA_ULICA_INSERT);
		adresa.setZip(BioskopConstants.DB_ADRESA_ZIP_INSERT);
		bioskop.setAdresa(adresa);

		String json = TestUtil.json(bioskop);
		this.mockMvc.perform(post(URL_DODAVANJE).contentType(contentType).content(json))
				.andExpect(status().isOk());
	}

}
