package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Prijatelj;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.PrijateljDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.PrijateljRep;
import com.isa_mrs_tim7.isa_mrs_tim7.service.PrijateljServis;


@RestController
public class PrijateljiController {
	
	
	@Autowired
	private PrijateljServis prijateljiService;
	 
	@Autowired
	private PrijateljRep prijateljRep;
	
	@RequestMapping(value = "/primljeniZahtevi",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Prijatelj> getZahtevi(@RequestBody PrijateljDTO prihvatio) {
		System.out.println("Je "+prihvatio);
		List<Prijatelj> list=prijateljRep.findByPrihvatioAndOpcija(prihvatio.getPoslao(),1);
	    return list;
	}
	
	@RequestMapping(
			value = "/kreiranjePrijatelja",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prijatelj> kreiranjePozorista(@RequestBody Prijatelj p) {
		

		Prijatelj pri=null;
	
		
		try {
			pri = prijateljiService.dodaj(p);
			if (pri == null) {
				//ue.setMessage("Already exist cinema/theater with the same name");
				//ue.setPlace(createPlace);
				System.out.println("Prijatelj vec postoji vec postoji u bazi!");
				return new ResponseEntity<Prijatelj>(HttpStatus.BAD_REQUEST);
			}
			
			//ue.setPlace(createPlace);
			//ue.setMessage("Place has been successfully created");
			
			
		} catch (Exception e1) {
			//ue.setMessage(e.getMessage());
			System.out.println(e1);
			
		}

		
		return new ResponseEntity<Prijatelj>(HttpStatus.CREATED);

	}
	
	@RequestMapping(
			value = "/updatePrijatelja",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prijatelj> updatePrijatelja(
			@RequestBody Prijatelj p) throws Exception {
		
		
		
		 Prijatelj updatedKorisnik = prijateljiService.update(p);
		if (updatedKorisnik == null) {
			System.out.println("Nije pronadjen");
			return new ResponseEntity<Prijatelj>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Prijatelj>(HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/obrisiPrijatelja",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prijatelj> obrisiPrijatelja(
			@RequestBody Prijatelj p) throws Exception {
		
		
		
		 Prijatelj updatedKorisnik = prijateljiService.obrisi(p);
		if (updatedKorisnik == null) {
			System.out.println("Nije pronadjen");
			return new ResponseEntity<Prijatelj>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Prijatelj>(HttpStatus.OK);
	}
	
	

}
