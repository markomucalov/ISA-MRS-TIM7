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
import com.isa_mrs_tim7.isa_mrs_tim7.constants.PrijateljConstants;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Prijatelj;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PrijateljiControllerTest {
	
	private static final String URL_PREFIX1 = "/kreiranjePrijatelja";
	private static final String URL_PREFIX2 = "/updatePrijatelja";
	private static final String URL_PREFIX3 = "/obrisiPrijatelja";
	
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
	public void testA() throws Exception {
		Prijatelj podaci=new Prijatelj();
		podaci.setPoslao(PrijateljConstants.DB_POSLAO);
		podaci.setPrihvatio(PrijateljConstants.DB_PRIHVATIO);
		podaci.setOpcija(PrijateljConstants.DB_OPCIJA1);
		

		String json = TestUtil.json(podaci);
		this.mockMvc.perform(post(URL_PREFIX3).contentType(contentType).content(json)).andExpect(status().isBadRequest());
	}



@Test
@Transactional
@Rollback(true)
public void testB() throws Exception {
	Prijatelj podaci=new Prijatelj();
	podaci.setPoslao(PrijateljConstants.DB_POSLAO);
	podaci.setPrihvatio(PrijateljConstants.DB_PRIHVATIO);
	podaci.setOpcija(PrijateljConstants.DB_OPCIJA1);
	

	String json = TestUtil.json(podaci);
	this.mockMvc.perform(post(URL_PREFIX1).contentType(contentType).content(json)).andExpect(status().isBadRequest());
}

@Test
@Transactional
@Rollback(true)
public void testC() throws Exception {
	Prijatelj podaci=new Prijatelj();
	podaci.setPoslao(PrijateljConstants.DB_POSLAO);
	podaci.setPrihvatio(PrijateljConstants.DB_PRIHVATIO);
	podaci.setOpcija(PrijateljConstants.DB_OPCIJA2);
	

	String json = TestUtil.json(podaci);
	this.mockMvc.perform(post(URL_PREFIX2).contentType(contentType).content(json)).andExpect(status().isOk());
}

}
