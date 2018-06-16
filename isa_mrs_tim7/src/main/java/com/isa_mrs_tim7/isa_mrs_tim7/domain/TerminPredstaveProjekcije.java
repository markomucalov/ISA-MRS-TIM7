package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "terminPredstaveProjekcije")
public class TerminPredstaveProjekcije implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Date datum;
	
	@Column(nullable = false)
	private Time pocetak;
	
	@Column(nullable = false)
	private Time kraj;
	
	@Column(nullable = false)
	private Time trajanje;
	
	@Column(nullable = false)
	private String naslov;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="sala_id", unique=false)
	@JsonBackReference
	private Sala sala;
	
	@OneToMany(mappedBy="terminPredstaveProjekcije")
	@JsonManagedReference
	private List<Karta> karte;

	public TerminPredstaveProjekcije() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Time getPocetak() {
		return pocetak;
	}

	public void setPocetak(Time pocetak) {
		this.pocetak = pocetak;
	}

	public Time getKraj() {
		return kraj;
	}

	public void setKraj(Time kraj) {
		this.kraj = kraj;
	}

	public Time getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Time trajanje) {
		this.trajanje = trajanje;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Karta> getKarte() {
		return karte;
	}

	public void setKarte(List<Karta> karte) {
		this.karte = karte;
	}

	
}
