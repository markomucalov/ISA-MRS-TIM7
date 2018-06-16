package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.sql.Date;
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
import com.isa_mrs_tim7.isa_mrs_tim7.constants.AdministratorPozorBiosConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sediste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipSedista;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.KonfiguracijaDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.SedisteDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.TerminPredstaveProjekcijeDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.service.BioskopService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.SalaService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.SedisteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorPozoristaBioskopaControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	
	@Autowired
	private BioskopService bioskopService;
	@Autowired
	private SalaService salaService;
	@Autowired
	private SedisteService sedisteService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateAdminPozBio() throws Exception {
		AdministratorPozoristaBioskopa adminPB = new AdministratorPozoristaBioskopa();
		adminPB.setIme(AdministratorPozorBiosConstants.ADMINPB_IME);
		adminPB.setPrezime(AdministratorPozorBiosConstants.ADMINPB_PREZIME);
		adminPB.setMailAdresa(AdministratorPozorBiosConstants.ADMINPB_EMAIL);
		adminPB.setKorisnickoIme(AdministratorPozorBiosConstants.ADMINPB_KORIME);
		adminPB.setLozinka(AdministratorPozorBiosConstants.ADMINPB_LOZINKA);

		String json = TestUtil.json(adminPB);
		this.mockMvc.perform(post("/jovaperic/izmenaPodatakaAdminaPB").contentType(contentType).content(json)).andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddSala() throws Exception{
		
		this.mockMvc.perform(post("/sala5/jovaperic/dodajSalu")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllSale() throws Exception{
		this.mockMvc.perform(get("/jovaperic/allSale")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.sale", hasSize(4)))
		.andExpect(jsonPath("$.sale[0]").value("sala1"));
	}
	
	@Test
	public void testGetKonfiguracijaSale() throws Exception{
		this.mockMvc.perform(get("/jovaperic/sala1/konfiguracijaSale")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(120)))
		.andExpect(jsonPath("$[0].tipSedista").value("VIP"))
		.andExpect(jsonPath("$[0].red").value(1))
		.andExpect(jsonPath("$[0].kolona").value(1))
		.andExpect(jsonPath("$[5].tipSedista").value("PROLAZ"))
		.andExpect(jsonPath("$[5].red").value(1))
		.andExpect(jsonPath("$[5].kolona").value(6));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateKonfiguracija() throws Exception{
		Bioskop bio = bioskopService.findByNaziv("CineStar Zrenjanin");
		Sala sala = salaService.findByNazivAndBioskop("sala3", bio);
		List<Sediste> sedista = sedisteService.findBySala(sala);
		List<SedisteDTO> sedistaDTO = new ArrayList<SedisteDTO>();
		for (Sediste sediste : sedista) {
			String tipSedista = "";
			if(sediste.getTipSedista() == TipSedista.OBICNO) {
				tipSedista = "obicno";
			}
			else if(sediste.getTipSedista() == TipSedista.ZA_BRZU_REZERVACIJU) {
				tipSedista = "brza";
			}
			else if(sediste.getTipSedista() == TipSedista.PROLAZ) {
				tipSedista = "prolaz";
			}
			else if(sediste.getTipSedista() == TipSedista.VIP) {
				tipSedista = "vip";
			}
			SedisteDTO sedDTO = new SedisteDTO(sediste.getRed(), sediste.getKolona(), tipSedista);
			sedistaDTO.add(sedDTO);
		}
		
		for (SedisteDTO sedisteDTO : sedistaDTO) {
			sedisteDTO.setTip("vip");
		}
		KonfiguracijaDTO konfDTO = new KonfiguracijaDTO("jovaperic", sedistaDTO, sala.getNaziv());
		
		String json = TestUtil.json(konfDTO);
		this.mockMvc.perform(post("/jovaperic/sala3/izmeniKonfiguraciju").contentType(contentType).content(json)).andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllTerminiBySalaDatum() throws Exception{
		this.mockMvc.perform(get("/jovaperic/sala1/2018-06-16/terminiSalaDatum")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].datum").value("2018-06-16"))
		.andExpect(jsonPath("$[0].naslov").value("Scarface"))
		.andExpect(jsonPath("$[0].pocetak").value("15:00:00"))
		.andExpect(jsonPath("$[1].datum").value("2018-06-16"))
		.andExpect(jsonPath("$[1].naslov").value("Ex machina"))
		.andExpect(jsonPath("$[1].pocetak").value("19:00:00"))
		.andExpect(jsonPath("$[1].karte", hasSize(98)));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddTerminPredstaveProjekcije() throws Exception{
		
		TerminPredstaveProjekcijeDTO terminDTO = new TerminPredstaveProjekcijeDTO("sala3", "Hitman", new Date(1529445600000L), "14:00:00", 200, 10, 500);
		
		String json = TestUtil.json(terminDTO);
		this.mockMvc.perform(post("/jovaperic/sala3/dodajTerminPrPro").contentType(contentType).content(json)).andExpect(status().isOk());
	}
}
