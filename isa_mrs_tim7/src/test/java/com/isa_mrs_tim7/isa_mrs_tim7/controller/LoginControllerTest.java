package com.isa_mrs_tim7.isa_mrs_tim7.controller;

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
//import com.isa_mrs_tim7.isa_mrs_tim7.constants.RegistrovaniKorisnikConstants;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.entity.LoginPodaci;

@RunWith(SpringRunner.class)
@SpringBootTest

public class LoginControllerTest {

	private static final String URL_PREFIX = "/login/provjeri";

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

/*	@Test
	@Transactional
	@Rollback(true)
	public void testLogin() throws Exception {
		LoginPodaci podaci = new LoginPodaci();
		podaci.setEmail(RegistrovaniKorisnikConstants.DB_LOGIN_EMAIL);
		podaci.setLozinka(RegistrovaniKorisnikConstants.DB_LOGIN_LOZINKA);

		String json = TestUtil.json(podaci);
		this.mockMvc.perform(post(URL_PREFIX).contentType(contentType).content(json)).andExpect(status().isOk());
	}*/

	

}
