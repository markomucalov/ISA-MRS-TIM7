package com.isa_mrs_tim7.isa_mrs_tim7.dto;

public class StatistikaDTO {
	
	private String pozoristeBioskop;
	private String filmPredstava;
	private Integer ocenaAmbijent;
	private Integer ocenaPredstavaProjekcija;
	
	public StatistikaDTO() {
	}

	public StatistikaDTO(String pozoristeBioskop, String filmPredstava, Integer ocenaAmbijent,
			Integer ocenaPredstavaProjekcija) {
		super();
		this.pozoristeBioskop = pozoristeBioskop;
		this.filmPredstava = filmPredstava;
		this.ocenaAmbijent = ocenaAmbijent;
		this.ocenaPredstavaProjekcija = ocenaPredstavaProjekcija;
	}

	public String getPozoristeBioskop() {
		return pozoristeBioskop;
	}

	public void setPozoristeBioskop(String pozoristeBioskop) {
		this.pozoristeBioskop = pozoristeBioskop;
	}

	public String getFilmPredstava() {
		return filmPredstava;
	}

	public void setFilmPredstava(String filmPredstava) {
		this.filmPredstava = filmPredstava;
	}

	public Integer getOcenaAmbijent() {
		return ocenaAmbijent;
	}

	public void setOcenaAmbijent(Integer ocenaAmbijent) {
		this.ocenaAmbijent = ocenaAmbijent;
	}

	public Integer getOcenaPredstavaProjekcija() {
		return ocenaPredstavaProjekcija;
	}

	public void setOcenaPredstavaProjekcija(Integer ocenaPredstavaProjekcija) {
		this.ocenaPredstavaProjekcija = ocenaPredstavaProjekcija;
	}
	
	

}
