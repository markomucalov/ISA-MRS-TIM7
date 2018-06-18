package com.isa_mrs_tim7.isa_mrs_tim7.dto;

public class KartaNaPopustuDTO {
	
	private String bioskopPozoriste;
	private String naslov;
	private String datum;
	private String pocetak;
	private String sala;
	private Integer red;
	private Integer kolona;
	private Integer staraCena;
	private Integer popust;
	private Integer novaCena;
	
	
	public KartaNaPopustuDTO() {
		
	}


	public KartaNaPopustuDTO(String bioskopPozoriste, String naslov, String datum, String pocetak, String sala,
			Integer red, Integer kolona, Integer staraCena, Integer popust, Integer novaCena) {
		super();
		this.bioskopPozoriste = bioskopPozoriste;
		this.naslov = naslov;
		this.datum = datum;
		this.pocetak = pocetak;
		this.sala = sala;
		this.red = red;
		this.kolona = kolona;
		this.staraCena = staraCena;
		this.popust = popust;
		this.novaCena = novaCena;
	}


	public String getBioskopPozoriste() {
		return bioskopPozoriste;
	}


	public void setBioskopPozoriste(String bioskopPozoriste) {
		this.bioskopPozoriste = bioskopPozoriste;
	}


	public String getNaslov() {
		return naslov;
	}


	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}


	public String getDatum() {
		return datum;
	}


	public void setDatum(String datum) {
		this.datum = datum;
	}


	public String getPocetak() {
		return pocetak;
	}


	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public Integer getRed() {
		return red;
	}


	public void setRed(Integer red) {
		this.red = red;
	}


	public Integer getKolona() {
		return kolona;
	}


	public void setKolona(Integer kolona) {
		this.kolona = kolona;
	}


	public Integer getStaraCena() {
		return staraCena;
	}


	public void setStaraCena(Integer staraCena) {
		this.staraCena = staraCena;
	}


	public Integer getPopust() {
		return popust;
	}


	public void setPopust(Integer popust) {
		this.popust = popust;
	}


	public Integer getNovaCena() {
		return novaCena;
	}


	public void setNovaCena(Integer novaCena) {
		this.novaCena = novaCena;
	}
	
	
	

}
