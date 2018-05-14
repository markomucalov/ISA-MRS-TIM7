package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.AdresaDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.BioskopDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.service.BioskopService;

@RestController
public class BioskopiController {

	@Autowired
	private BioskopService bioskopService;
	
	@RequestMapping(value = "/bioskopi",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Bioskop> getAllBioskopi() {
	    return bioskopService.getAllBioskopi(PageRequest.of(0, 10));
	}
	
	@RequestMapping(value="/{bioskopNaziv}/bioskop", method=RequestMethod.GET)
	public ResponseEntity<Bioskop> getBioskop(@PathVariable String bioskopNaziv){
		
		Bioskop bioskop = bioskopService.findByNaziv(bioskopNaziv);
		
		// course must exist
		if(bioskop == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(bioskop, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{bioskopNaziv}/filmovi/{strana}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Page<Film>> getFilmoviByBioskop(@PathVariable String bioskopNaziv, @PathVariable String strana) {
		Bioskop bioskop = bioskopService.findByNaziv(bioskopNaziv);
		return new ResponseEntity<>(bioskopService.getFilmovi(bioskop, PageRequest.of(Integer.parseInt(strana), 4)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{bioskopNaziv}/izmenaPodataka", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<BioskopDTO> updateBioskop(@PathVariable String bioskopNaziv, @RequestBody BioskopDTO bioskopDTO){
		
		Bioskop bioskop = bioskopService.findByNaziv(bioskopNaziv); 
		
		if (bioskop == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		bioskop.setNaziv(bioskopDTO.getNaziv());
		Adresa adresa = bioskop.getAdresa();
		adresa.setBroj(bioskopDTO.getAdresa().getBroj());
		adresa.setUlica(bioskopDTO.getAdresa().getUlica());
		adresa.setGrad(bioskopDTO.getAdresa().getGrad());
		adresa.setZip(bioskopDTO.getAdresa().getZip());
		bioskop.setAdresa(adresa);
		AdresaDTO adresaDTO = new AdresaDTO(adresa.getUlica(), adresa.getBroj(), adresa.getGrad(), adresa.getZip());
		bioskop.setPromotivniOpis(bioskopDTO.getPromotivniOpis());
	
		bioskop = bioskopService.save(bioskop);
		return new ResponseEntity<BioskopDTO>(new BioskopDTO(bioskop.getNaziv(), adresaDTO, bioskop.getPromotivniOpis()), HttpStatus.OK);	
	}
}
