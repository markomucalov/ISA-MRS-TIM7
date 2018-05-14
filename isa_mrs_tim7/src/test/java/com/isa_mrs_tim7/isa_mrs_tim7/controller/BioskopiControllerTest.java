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

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.isa_mrs_tim7.isa_mrs_tim7.TestUtil;
import com.isa_mrs_tim7.isa_mrs_tim7.constants.BioskopConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioskopiControllerTest {
	
	private static final String URL_PREFIX = "/bioskopi";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

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

}
