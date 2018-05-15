package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.AdministratorPozBiDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.service.AdministratorPozoristaBioskopaService;

@RestController
public class AdministratorPozoristaBioskopaController {

	@Autowired
	AdministratorPozoristaBioskopaService adminPozBioSer;
	
	@RequestMapping(value="/{adminIme}/bioskopPozoristeAdmin", method=RequestMethod.GET)
	public ResponseEntity<AdministratorPozoristaBioskopa> getBioskop(@PathVariable String adminIme){
		
		AdministratorPozoristaBioskopa administrator = adminPozBioSer.findByKorIme(adminIme);
		
		
		if(administrator == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(administrator, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{adminKorIme}/izmenaPodatakaAdminaPB", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<AdministratorPozBiDTO> updateBioskop(@PathVariable String adminKorIme, @RequestBody AdministratorPozBiDTO adminPozBiDTO){
		
		AdministratorPozoristaBioskopa adminPB = adminPozBioSer.findByKorIme(adminKorIme); 
		
		if (adminPB == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		adminPB.setIme(adminPozBiDTO.getIme());
		adminPB.setPrezime(adminPozBiDTO.getPrezime());
		adminPB.setKorisnickoIme(adminPozBiDTO.getKorisnickoIme());
		adminPB.setMailAdresa(adminPozBiDTO.getMailAdresa());
		adminPB.setLozinka(adminPozBiDTO.getLozinka());
	
		adminPozBioSer.save(adminPB);
		return new ResponseEntity<AdministratorPozBiDTO>(adminPozBiDTO, HttpStatus.OK);	
	}
}
