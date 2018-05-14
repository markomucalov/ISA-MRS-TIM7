package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.DB_ADRESA_BROJ;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.DB_ADRESA_GRAD;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.DB_ADRESA_ULICA;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.DB_ADRESA_ZIP;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.DB_NAZIV;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.DB_REJTING;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.PAGE_SIZE;
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
import com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PozoristaControlerTest {
	
	private static final String URL_PREFIX = "/pozorista";
	private static final String URL_PREFIX_DODAVANJE = "/kreiranjePozorista";
	
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
	public void testGetPozoristaPage() throws Exception {
		mockMvc.perform(get(URL_PREFIX+"?page=0&size=" + PAGE_SIZE)).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.content", hasSize(PAGE_SIZE)))
				.andExpect(jsonPath("$.content[0].naziv").value(DB_NAZIV))
				.andExpect(jsonPath("$.content[0].rejting").value(DB_REJTING))
				.andExpect(jsonPath("$.content[0].adresa.ulica").value(DB_ADRESA_ULICA))
				.andExpect(jsonPath("$.content[0].adresa.broj").value(DB_ADRESA_BROJ))
				.andExpect(jsonPath("$.content[0].adresa.grad").value(DB_ADRESA_GRAD))
				.andExpect(jsonPath("$.content[0].adresa.zip").value(DB_ADRESA_ZIP));
	}
	
	/*@Test
	public void testGetPozoriste() throws Exception {
		mockMvc.perform(get("/CineStar Zrenjanin/bioskop")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.naziv").value(DB_NAZIV))
				.andExpect(jsonPath("$.rejting").value(DB_REJTING))
				.andExpect(jsonPath("$.adresa.ulica").value(DB_ADRESA_ULICA))
				.andExpect(jsonPath("$.adresa.broj").value(DB_ADRESA_BROJ))
				.andExpect(jsonPath("$.adresa.grad").value(DB_ADRESA_GRAD))
				.andExpect(jsonPath("$.adresa.zip").value(DB_ADRESA_ZIP));
	}*/
	
	@Test
	public void testGetFilmoviPage() throws Exception {
		mockMvc.perform(get("/SNP/predstave/0")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.content", hasSize(1)))
				.andExpect(jsonPath("$.content[0].naizv").value("Seviljski berberin"))
				.andExpect(jsonPath("$.content[0].zanr").value("komedija"))
				.andExpect(jsonPath("$.content[0].imeReditelja").value("Ivan Klemenc"));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSacuvajPozoriste() throws Exception {
		Pozoriste pozoriste = new Pozoriste();
		pozoriste.setNaziv(PozoristeConstants.DB_NAZIV_INSERT);
		pozoriste.setRejting(PozoristeConstants.DB_REJTING_INSERT);
		
		Adresa adresa = new Adresa();
		adresa.setUlica(PozoristeConstants.DB_ADRESA_ULICA_INSERT);
		adresa.setBroj(PozoristeConstants.DB_ADRESA_BROJ_INSERT);
		adresa.setGrad(PozoristeConstants.DB_ADRESA_GRAD_INSERT);
		adresa.setZip(PozoristeConstants.DB_ADRESA_ZIP_INSERT);

		String json = TestUtil.json(pozoriste);
		this.mockMvc.perform(post(URL_PREFIX_DODAVANJE).contentType(contentType).content(json)).andExpect(status().isOk());
	}
}
