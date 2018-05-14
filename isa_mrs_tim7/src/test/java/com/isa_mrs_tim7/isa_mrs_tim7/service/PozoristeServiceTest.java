package com.isa_mrs_tim7.isa_mrs_tim7.service;

import static com.isa_mrs_tim7.isa_mrs_tim7.constants.PozoristeConstants.PAGE_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Predstava;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PozoristeServiceTest {
	
	@Autowired
	PozoristeService pozoristeService;
	
	@Test
	public void testGetAllPozorista() {
		PageRequest pageRequest = PageRequest.of(0, PAGE_SIZE); //second page
		Page<Pozoriste> pozorista = pozoristeService.getAllPozorista(pageRequest);
		assertThat(pozorista).hasSize(PAGE_SIZE); 
	}
	
	@Test
	public void testFindByNaziv() {
		String naziv = "SNP";
		Pozoriste pozoriste = pozoristeService.findByNaziv(naziv);
		assertThat(pozoriste).hasFieldOrPropertyWithValue("naziv", "SNP");
		assertThat(pozoriste).hasFieldOrPropertyWithValue("rejting", 3);
	}
	
	@Test
	public void testGetPredstave() {
		PageRequest pageRequest = PageRequest.of(0, 4);
		String naziv = "SNP";
		Pozoriste pozoriste = pozoristeService.findByNaziv(naziv);
		Page<Predstava> predstave = pozoristeService.getPredstave(pozoriste, pageRequest);
		assertThat(predstave).hasSize(1);
	}

}
