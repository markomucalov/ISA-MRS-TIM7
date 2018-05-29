package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.AdministratorPozoristaBioskopa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sala;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Sediste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.TipSedista;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.AdministratorPozBiDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.KonfiguracijaDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.SaleDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.dto.SedisteDTO;
import com.isa_mrs_tim7.isa_mrs_tim7.service.AdministratorPozoristaBioskopaService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.BioskopService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.PozoristeService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.SalaService;
import com.isa_mrs_tim7.isa_mrs_tim7.service.SedisteService;

@RestController
public class AdministratorPozoristaBioskopaController {

	@Autowired
	AdministratorPozoristaBioskopaService adminPozBioSer;
	
	@Autowired
	BioskopService bioskopService;
	
	@Autowired
	PozoristeService pozoristeService;
	
	@Autowired
	SalaService salaService;
	
	@Autowired
	SedisteService sedisteService;
	
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
	
	@RequestMapping(value = "/{nazivSale}/{adminKorIme}/dodajSalu", method=RequestMethod.POST)
	public ResponseEntity<String> addSala(@PathVariable String nazivSale, @PathVariable String adminKorIme){
		
		AdministratorPozoristaBioskopa adminPB = adminPozBioSer.findByKorIme(adminKorIme);
		
		Pozoriste poz;
		Bioskop bio;
		
		if(adminPB == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(adminPB.getBioskop() != null) {
			bio = adminPB.getBioskop();
			
			Sala salaProvera = salaService.findByNazivAndBioskop(nazivSale, bio);
			
			if(salaProvera != null) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
			Sala sala = new Sala();
			sala.setBioskop(bio);
			sala.setNaziv(nazivSale);		
			List<Sediste> sedista = new ArrayList<Sediste>();
			salaService.save(sala);
			sala.setSedista(sedista);
			for(int i = 1; i <= 10; i++) {
				for(int j = 1; j <= 12; j++) {
					Sediste sediste = new Sediste();
					sediste.setRed(i);
					sediste.setKolona(j);
					sediste.setTipSedista(TipSedista.OBICNO);
					sediste.setSala(sala);
					sedisteService.save(sediste);
					sala.getSedista().add(sediste);
				}
			}
			
			bio.getSale().add(sala);
			salaService.save(sala);
			bioskopService.save(bio);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		else if(adminPB.getPozoriste() != null) {
			poz = adminPB.getPozoriste();
			
			Sala salaProvera = salaService.findByNazivAndPozoriste(nazivSale, poz);
			
			if(salaProvera != null) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
			Sala sala = new Sala();
			sala.setPozoriste(poz);
			sala.setNaziv(nazivSale);			
			List<Sediste> sedista = new ArrayList<Sediste>();
			salaService.save(sala);
			sala.setSedista(sedista);
			for(int i = 1; i <= 10; i++) {
				for(int j = 1; j <= 12; j++) {
					Sediste sediste = new Sediste();
					sediste.setRed(i);
					sediste.setKolona(j);
					sediste.setTipSedista(TipSedista.OBICNO);
					sediste.setSala(sala);
					sedisteService.save(sediste);
					sala.getSedista().add(sediste);
				}
			}
			poz.getSale().add(sala);
			salaService.save(sala);
			pozoristeService.save(poz);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{adminKorIme}/allSale", method=RequestMethod.GET)
	public ResponseEntity<SaleDTO> getAllSale(@PathVariable String adminKorIme){
		
		AdministratorPozoristaBioskopa adminPB = adminPozBioSer.findByKorIme(adminKorIme);
		
		Pozoriste poz;
		Bioskop bio;
		
		SaleDTO saleDTO = new SaleDTO();
		
		if(adminPB == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(adminPB.getBioskop() != null) {
			bio = adminPB.getBioskop();
			List<Sala> sale = bio.getSale();
			List<String> saleNazivDTO = new ArrayList<String>();
			for (Sala sala : sale) {
				saleNazivDTO.add(sala.getNaziv());
			}
			saleDTO.setSale(saleNazivDTO);
			return new ResponseEntity<>(saleDTO, HttpStatus.OK);
		}
		
		else if(adminPB.getPozoriste() != null) {
			poz = adminPB.getPozoriste();
			List<Sala> sale = poz.getSale();
			List<String> saleNazivDTO = new ArrayList<String>();
			for (Sala sala : sale) {
				saleNazivDTO.add(sala.getNaziv());
			}
			saleDTO.setSale(saleNazivDTO);
			return new ResponseEntity<>(saleDTO, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value = "/{adminKorIme}/{nazivSale}/konfiguracijaSale", method=RequestMethod.GET)
	public ResponseEntity<List<Sediste>> getKonfiguracijaSale(@PathVariable String adminKorIme, @PathVariable String nazivSale){
		
		AdministratorPozoristaBioskopa adminPB = adminPozBioSer.findByKorIme(adminKorIme);
		
		Pozoriste poz;
		Bioskop bio;
		
		if(adminPB == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(adminPB.getBioskop() != null) {
			bio = adminPB.getBioskop();
			Sala sl = null;
			for (Sala s : bio.getSale()) {
				if(s.getNaziv().equals(nazivSale)) {
					sl = s;
				}
			}		
			List<Sediste> sedista = sl.getSedista();
			return new ResponseEntity<>(sedista, HttpStatus.OK);
		}
		else if(adminPB.getPozoriste() != null) {
			poz = adminPB.getPozoriste();
			Sala sl = null;
			for (Sala s : poz.getSale()) {
				if(s.getNaziv().equals(nazivSale)) {
					sl = s;
				}
			}		
			List<Sediste> sedista = sl.getSedista();
			return new ResponseEntity<>(sedista, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{adminKorIme}/{salaNaziv}/izmeniKonfiguraciju", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> updateBioskop(@PathVariable String adminKorIme, @PathVariable String salaNaziv, @RequestBody KonfiguracijaDTO konfiguracijaDTO){
		
		AdministratorPozoristaBioskopa adminPB = adminPozBioSer.findByKorIme(adminKorIme);
		
		if(adminPB == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(adminPB.getBioskop() != null) {
			Bioskop bio = adminPB.getBioskop();
			Sala sala = salaService.findByNazivAndBioskop(salaNaziv, bio);
			List<Sediste> sedista = sedisteService.findBySala(sala);
			List<SedisteDTO> sedistaDTO = konfiguracijaDTO.getSedista();
			
			for (Sediste sediste : sedista) {
				for(SedisteDTO sedisteDTO : sedistaDTO)
				if(sediste.getRed() == sedisteDTO.getRed() && sediste.getKolona() == sedisteDTO.getKolona()) {
					if(sedisteDTO.getTip().equals("obicno")) {
						sediste.setTipSedista(TipSedista.OBICNO);
						sedisteService.save(sediste);
					}
					else if(sedisteDTO.getTip().equals("brza")) {
						sediste.setTipSedista(TipSedista.ZA_BRZU_REZERVACIJU);
						sedisteService.save(sediste);
					}
					else if(sedisteDTO.getTip().equals("vip")) {
						sediste.setTipSedista(TipSedista.VIP);
						sedisteService.save(sediste);
					}
					else if(sedisteDTO.getTip().equals("prolaz")) {
						sediste.setTipSedista(TipSedista.PROLAZ);
						sedisteService.save(sediste);
					}
				}
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		else if(adminPB.getPozoriste() != null) {
			Pozoriste poz = adminPB.getPozoriste();
			Sala sala = salaService.findByNazivAndPozoriste(salaNaziv, poz);
			List<Sediste> sedista = sedisteService.findBySala(sala);
			List<SedisteDTO> sedistaDTO = konfiguracijaDTO.getSedista();
			
			for (Sediste sediste : sedista) {
				for(SedisteDTO sedisteDTO : sedistaDTO)
				if(sediste.getRed() == sedisteDTO.getRed() && sediste.getKolona() == sedisteDTO.getKolona()) {
					if(sedisteDTO.getTip().equals("obicno")) {
						sediste.setTipSedista(TipSedista.OBICNO);
						sedisteService.save(sediste);
					}
					else if(sedisteDTO.getTip().equals("brza")) {
						sediste.setTipSedista(TipSedista.ZA_BRZU_REZERVACIJU);
						sedisteService.save(sediste);
					}
					else if(sedisteDTO.getTip().equals("vip")) {
						sediste.setTipSedista(TipSedista.VIP);
						sedisteService.save(sediste);
					}
					else if(sedisteDTO.getTip().equals("prolaz")) {
						sediste.setTipSedista(TipSedista.PROLAZ);
						sedisteService.save(sediste);
					}
				}
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
