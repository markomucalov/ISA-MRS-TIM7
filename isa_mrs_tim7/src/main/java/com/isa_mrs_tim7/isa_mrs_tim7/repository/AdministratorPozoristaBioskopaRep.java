package com.isa_mrs_tim7.isa_mrs_tim7.repository;

import org.springframework.data.repository.Repository;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;

public interface AdministratorPozoristaBioskopaRep extends Repository<AdministratorPozoristaBioskopa, Long> {
	
	AdministratorPozoristaBioskopa findOneByKorisnickoIme(String ime);
	void save(AdministratorPozoristaBioskopa adminPozBi);
}
