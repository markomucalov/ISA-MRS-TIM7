package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.RegistrovaniKorisnikRep;


@Service
public class ServisLoginImpl implements ServisLogin {

	@Autowired
	private RegistrovaniKorisnikRep registrovaniKorisnikRep;

	@Override
	public RegistrovaniKorisnik getKorisnik(String email, String lozinka) {
		// TODO Auto-generated method stub
		Assert.notNull(email, "Email ne sme biti null");
		Assert.notNull(lozinka, "Lozinka ne sme biti null");
		System.out.println(email);
		
		RegistrovaniKorisnik kor =this.registrovaniKorisnikRep.findByEmailAndLozinka(email, lozinka);
		System.out.println(kor.getIme());
		return kor;
	}

}
