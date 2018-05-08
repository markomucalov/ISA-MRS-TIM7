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

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.service.BioskopService;

@RestController
public class BioskopiController {

	@Autowired
	private BioskopService bioskopService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/bioskopi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Bioskop> getAllBioskopi() {
		return bioskopService.getAllBioskopi(PageRequest.of(0, 10));	
	
	}
	@PostMapping(value = "/kreiranjeBioskopa", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Bioskop kreiranjeBioskopa(@RequestBody Bioskop b) {
		logger.info("> dodavanjeBioskopa");

		Bioskop unesiBioskop = null;
		Exception e = new Exception();
		System.out.println(b.getNaziv());
		try {
			unesiBioskop = bioskopService.unesiBioskop(b);
			if (unesiBioskop == null) {
				//ue.setMessage("Already exist cinema/theater with the same name");
				//ue.setPlace(createPlace);
				System.out.println("Postoji");
				return null;
			}
			
			//ue.setPlace(createPlace);
			//ue.setMessage("Place has been successfully created");
			
			
		} catch (Exception e1) {
			//ue.setMessage(e.getMessage());
			System.out.println(e);
			return null;
		}

		logger.info("> dodavanjeBioskopa");
		return unesiBioskop;

	}
	
	
	
}

