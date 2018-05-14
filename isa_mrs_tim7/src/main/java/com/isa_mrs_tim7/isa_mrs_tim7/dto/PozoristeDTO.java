package com.isa_mrs_tim7.isa_mrs_tim7.dto;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;

public class PozoristeDTO {
	private Long id;
	private String naziv;
	private Adresa adresa;
	private String promotivniOpis;
	
	public PozoristeDTO() {
	}
	
	public PozoristeDTO(Pozoriste pozoriste) {
		this(pozoriste.getId(), pozoriste.getNaziv(), pozoriste.getAdresa(), pozoriste.getPromotivniOpis());
	}
	
	public PozoristeDTO(Long id, String naziv, Adresa adresa, String promotivniOpis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.promotivniOpis = promotivniOpis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getPromotivniOpis() {
		return promotivniOpis;
	}

	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}
	
	
}
