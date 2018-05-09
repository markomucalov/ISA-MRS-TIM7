package com.isa_mrs_tim7.isa_mrs_tim7.service;

import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_BROJ;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_GRAD;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_ID;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_ULICA;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_ZIP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = Pozoriste.class)
public class AdresaServiceTest {
	
	private static final String URL_PREFIX = "/adresa";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	
	@Autowired
	AdresaService adresaService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}
	
	@Test 
	public void testGetAdresa() {
		Adresa dbAdresa = adresaService.getAdresa(DB_ID);
		assertThat(dbAdresa).isNotNull();
		
		assertThat(dbAdresa.getUlica()).isEqualTo(DB_ULICA);
		assertThat(dbAdresa.getBroj()).isEqualTo(DB_BROJ);
        assertThat(dbAdresa.getGrad()).isEqualTo(DB_GRAD);
        assertThat(dbAdresa.getZip()).isEqualTo(DB_ZIP);  
	}
	
}
