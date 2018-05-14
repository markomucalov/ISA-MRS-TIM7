package com.isa_mrs_tim7.isa_mrs_tim7.dto;

public class BioskopDTO {
	private String naziv;
	private AdresaDTO adresa;
	private String promotivniOpis;
	
	public BioskopDTO() {
	}
	
	public BioskopDTO(String naziv, AdresaDTO adresa, String promotivniOpis) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.promotivniOpis = promotivniOpis;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public String getPromotivniOpis() {
		return promotivniOpis;
	}

	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}
	
		
}
