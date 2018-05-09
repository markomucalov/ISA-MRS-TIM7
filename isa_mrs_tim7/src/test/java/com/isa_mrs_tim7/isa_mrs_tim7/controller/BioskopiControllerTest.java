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
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;

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

	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetStudentsPage() throws Exception {
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
	@Transactional
	@Rollback(true)
	public void testDodavanjeBioskopa() throws Exception {
		Bioskop bioskop = new Bioskop();
		bioskop.setNaziv(BioskopConstants.DB_NAZIV);
		bioskop.setRejting(BioskopConstants.DB_REJTING);
		Adresa adresa = new Adresa();
		adresa.setBroj(BioskopConstants.DB_ADRESA_BROJ);
		adresa.setGrad(BioskopConstants.DB_ADRESA_GRAD);
		adresa.setUlica(BioskopConstants.DB_ADRESA_ULICA);
		adresa.setZip(BioskopConstants.DB_ADRESA_ZIP);
		bioskop.setAdresa(adresa);

		String json = TestUtil.json(bioskop);
		this.mockMvc.perform(post(URL_DODAVANJE).contentType(contentType).content(json))
				.andExpect(status().isOk());
	}

}
