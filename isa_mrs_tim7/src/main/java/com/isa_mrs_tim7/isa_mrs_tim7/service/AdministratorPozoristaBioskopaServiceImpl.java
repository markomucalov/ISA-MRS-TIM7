package com.isa_mrs_tim7.isa_mrs_tim7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.AdministratorPozoristaBioskopaRep;

@Service
public class AdministratorPozoristaBioskopaServiceImpl implements AdministratorPozoristaBioskopaService {

	@Autowired
	private AdministratorPozoristaBioskopaRep adminRep;
	
	@Override
	public AdministratorPozoristaBioskopa findByKorIme(String korIme) {
		return adminRep.findOneByKorisnickoIme(korIme);
	}
	
	@Override
	public void save(AdministratorPozoristaBioskopa adminPozBi) {
		adminRep.save(adminPozBi);
	}
}
