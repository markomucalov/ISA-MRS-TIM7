package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "karta")
public class Karta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="terminPredstaveProjekcije_id", unique=false)
	@JsonBackReference
	private TerminPredstaveProjekcije terminPredstaveProjekcije;
	
	@Column(nullable = false)
	private Integer kolona;
	
	@Column(nullable = false)
	private Integer red;
	
	@Column(nullable = false)
	private Integer cena;
	
	@Column(nullable = false)
	private Integer popust;
	
	@Column(nullable = false)
	private TipKarte tipKarte;
	
	@Column(nullable = false)
	private Boolean prodata;

	public Karta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TerminPredstaveProjekcije getTerminPredstaveProjekcije() {
		return terminPredstaveProjekcije;
	}

	public void setTerminPredstaveProjekcije(TerminPredstaveProjekcije terminPredstaveProjekcije) {
		this.terminPredstaveProjekcije = terminPredstaveProjekcije;
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

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}

	public Integer getPopust() {
		return popust;
	}

	public void setPopust(Integer popust) {
		this.popust = popust;
	}

	public TipKarte getTipKarte() {
		return tipKarte;
	}

	public void setTipKarte(TipKarte tipKarte) {
		this.tipKarte = tipKarte;
	}

	public Boolean getProdata() {
		return prodata;
	}

	public void setProdata(Boolean prodata) {
		this.prodata = prodata;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
