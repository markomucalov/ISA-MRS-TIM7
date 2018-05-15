package com.isa_mrs_tim7.isa_mrs_tim7.service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;

public interface AdministratorPozoristaBioskopaService {

	AdministratorPozoristaBioskopa findByKorIme(String korIme);
	void save(AdministratorPozoristaBioskopa adminPozBi);
}
