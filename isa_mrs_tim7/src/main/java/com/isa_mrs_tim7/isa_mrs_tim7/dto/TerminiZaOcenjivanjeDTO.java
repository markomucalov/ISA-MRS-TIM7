package com.isa_mrs_tim7.isa_mrs_tim7.dto;

public class TerminiZaOcenjivanjeDTO {
	
	private String bioskopPozoriste;
	private String naslov;
	private String datum;
	private Integer kolona;
	private Integer red;
	private Integer ocenaAmbijent;
	private Integer ocenaPredPro;
	
	
	public TerminiZaOcenjivanjeDTO() {
	}	
	
	

	public TerminiZaOcenjivanjeDTO(String bioskopPozoriste, String naslov, String datum, Integer kolona, Integer red,
			Integer ocenaAmbijent, Integer ocenaPredPro) {
		super();
		this.bioskopPozoriste = bioskopPozoriste;
		this.naslov = naslov;
		this.datum = datum;
		this.kolona = kolona;
		this.red = red;
		this.ocenaAmbijent = ocenaAmbijent;
		this.ocenaPredPro = ocenaPredPro;
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

	public Integer getKolona() {
		return kolona;
	}

	public void setKolona(Integer kolona) {
		this.kolona = kolona;
	}

	public Integer getRed() {
		return red;
	}

	public void setRed(Integer red) {
		this.red = red;
	}



	public Integer getOcenaAmbijent() {
		return ocenaAmbijent;
	}



	public void setOcenaAmbijent(Integer ocenaAmbijent) {
		this.ocenaAmbijent = ocenaAmbijent;
	}



	public Integer getOcenaPredPro() {
		return ocenaPredPro;
	}



	public void setOcenaPredPro(Integer ocenaPredPro) {
		this.ocenaPredPro = ocenaPredPro;
	}
	
	

}
