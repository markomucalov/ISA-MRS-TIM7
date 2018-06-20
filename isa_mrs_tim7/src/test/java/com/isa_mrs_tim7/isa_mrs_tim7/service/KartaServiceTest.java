package com.isa_mrs_tim7.isa_mrs_tim7.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Karta;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KartaServiceTest {
	
	@Autowired
	private KartaService kartaService;
	
	@Autowired
	private ServisLogin korisnikService;

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void testUpdate(){
		
		Karta kartaZaPrvogKorisnika = kartaService.findById(2686L);
		Karta kartaZaDrugogKorisnika = kartaService.findById(2686L);
		
		RegistrovaniKorisnik k1 = korisnikService.findByEmailAndImeAndPrezime("petarpetrovic@yahoo.com", "Petar", "Petrovic");
		RegistrovaniKorisnik k2 = korisnikService.findByEmailAndImeAndPrezime("jelenapejicic2008@hotmail.com", "Jelena", "Pejicic");
		
		kartaZaPrvogKorisnika.setRegistrovaniKorisnik(k1);
		kartaZaDrugogKorisnika.setRegistrovaniKorisnik(k2);
		
		assertEquals(0, kartaZaPrvogKorisnika.getVersion().intValue());
		assertEquals(0, kartaZaDrugogKorisnika.getVersion().intValue());
		
		kartaService.save(kartaZaPrvogKorisnika);
		kartaService.save(kartaZaDrugogKorisnika);
	}
}
