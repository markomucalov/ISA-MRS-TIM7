package com.isa_mrs_tim7.isa_mrs_tim7.dto;

import java.sql.Time;
import java.util.List;

public class FilmDTO {

	private String naizv;
	
	private List<String> spisakGlumaca;
	
	private String zanr;
	
	private String imeReditelja;
	
	private Time trajanje;
	
	private String opis;
	
	private Integer cena;

	public FilmDTO(String naizv, List<String> spisakGlumaca, String zanr, String imeReditelja, Time trajanje,
			String opis, Integer cena) {
		super();
		this.naizv = naizv;
		this.spisakGlumaca = spisakGlumaca;
		this.zanr = zanr;
		this.imeReditelja = imeReditelja;
		this.trajanje = trajanje;
		this.opis = opis;
		this.cena = cena;
	}

	public FilmDTO() {
		super();
	}

	public String getNaizv() {
		return naizv;
	}

	public void setNaizv(String naizv) {
		this.naizv = naizv;
	}

	public List<String> getSpisakGlumaca() {
		return spisakGlumaca;
	}

	public void setSpisakGlumaca(List<String> spisakGlumaca) {
		this.spisakGlumaca = spisakGlumaca;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getImeReditelja() {
		return imeReditelja;
	}

	public void setImeReditelja(String imeReditelja) {
		this.imeReditelja = imeReditelja;
	}

	public Time getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Time trajanje) {
		this.trajanje = trajanje;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}	
}
