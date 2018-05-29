package com.isa_mrs_tim7.isa_mrs_tim7.dto;

import java.util.List;

public class KonfiguracijaDTO {

	private String korisnickoIme;
	private List<SedisteDTO> sedista;
	private String sala;
	
	public KonfiguracijaDTO(String korisnickoIme, List<SedisteDTO> sedista, String sala) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.sedista = sedista;
		this.sala = sala;
	}
	
	

	public KonfiguracijaDTO() {
		super();
	}



	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public List<SedisteDTO> getSedista() {
		return sedista;
	}

	public void setSedista(List<SedisteDTO> sedista) {
		this.sedista = sedista;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	
}
