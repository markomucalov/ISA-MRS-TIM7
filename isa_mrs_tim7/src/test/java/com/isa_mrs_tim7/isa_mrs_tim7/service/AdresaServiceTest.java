package com.isa_mrs_tim7.isa_mrs_tim7.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_ID;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_ULICA;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_BROJ;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_GRAD;
import static com.isa_mrs_tim7.isa_mrs_tim7.constants.AdresaConstants.DB_ZIP;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdresaServiceTest {
	
	@Autowired
	AdresaService adresaService;
	
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
