package com.isa_mrs_tim7.isa_mrs_tim7.controller;

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
import com.isa_mrs_tim7.isa_mrs_tim7.constants.AdministratorPozorBiosConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorPozoristaBioskopaControllerTest {

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
		this.mockMvc.perform(post("/peraperic/izmenaPodatakaAdminaPB").contentType(contentType).content(json)).andExpect(status().isOk());
	}
}
