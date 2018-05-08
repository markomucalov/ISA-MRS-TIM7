package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.service.PozoristeService;


@RestController
public class PozoristaController {
	
	@Autowired
	private PozoristeService pozoristeService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/pozorista",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Pozoriste> getAllPozorista() {
	    return pozoristeService.getAllPozorista(PageRequest.of(0, 10));
	}
	
	@PostMapping(value = "/kreiranjePozorista", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pozoriste kreiranjePozorista(@RequestBody Pozoriste p) {
		logger.info("> dodavanjePozorista");

		Pozoriste unesiPozoriste = null;
		Exception e = new Exception();
		System.out.println(p.getNaziv());
		try {
			unesiPozoriste = pozoristeService.unesiPozoriste(p);
			if (unesiPozoriste == null) {
				//ue.setMessage("Already exist cinema/theater with the same name");
				//ue.setPlace(createPlace);
				System.out.println("Pozoriste vec postoji u bazi!");
				return null;
			}
			
			//ue.setPlace(createPlace);
			//ue.setMessage("Place has been successfully created");
			
			
		} catch (Exception e1) {
			//ue.setMessage(e.getMessage());
			System.out.println(e);
			return null;
		}

		logger.info("> dodavanjePozorista");
		return unesiPozoriste;

	}
	

}
