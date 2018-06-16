package com.isa_mrs_tim7.isa_mrs_tim7.dto;

import java.sql.Date;

public class TerminPredstaveProjekcijeDTO {

	private String sala;
	private String naslov;
	private Date datum;
	private String vreme;
	private Integer cenaObicne;
	private Integer popust;
	private Integer cenaVip;
	
	public TerminPredstaveProjekcijeDTO() {
	}

	public TerminPredstaveProjekcijeDTO(String sala, String naslov, Date datum, String vreme, Integer cenaObicne,
			Integer popust, Integer cenaVip) {
		super();
		this.sala = sala;
		this.naslov = naslov;
		this.datum = datum;
		this.vreme = vreme;
		this.cenaObicne = cenaObicne;
		this.popust = popust;
		this.cenaVip = cenaVip;
	}



	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Integer getCenaObicne() {
		return cenaObicne;
	}

	public void setCenaObicne(Integer cenaObicne) {
		this.cenaObicne = cenaObicne;
	}

	public Integer getPopust() {
		return popust;
	}

	public void setPopust(Integer popust) {
		this.popust = popust;
	}

	public Integer getCenaVip() {
		return cenaVip;
	}

	public void setCenaVip(Integer cenaVip) {
		this.cenaVip = cenaVip;
	}
}
