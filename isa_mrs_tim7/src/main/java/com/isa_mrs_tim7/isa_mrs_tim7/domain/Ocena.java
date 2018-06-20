package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.sql.Date;

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
@Table(name = "ocena")
public class Ocena {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="bioskop_id", unique=false)
	@JsonBackReference
	private Bioskop bioskop;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="pozoriste_id", unique=false)
	@JsonBackReference
	private Pozoriste pozoriste;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="film_id", unique=false)
	@JsonBackReference
	private Film film;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="predstava_id", unique=false)
	@JsonBackReference
	private Predstava predstava;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="korisnik_id", unique=false)
	@JsonBackReference
	private RegistrovaniKorisnik korisnik;
	
	@Column(nullable = false)
	private Date datum;
	
	@Column(nullable = false)
	private Integer red;
	
	@Column(nullable = false)
	private Integer kolona;
	
	@Column(nullable = false)
	private Integer ocenaAmbijent;
	
	@Column(nullable = false)
	private Integer ocenaPredstavaProjekcija;

	public Ocena() {
	}

	

	public Ocena(Bioskop bioskop, Pozoriste pozoriste, Film film, Predstava predstava,
			RegistrovaniKorisnik korisnik, Date datum, Integer red, Integer kolona, Integer ocenaAmbijent,
			Integer ocenaPredstavaProjekcija) {
		this.bioskop = bioskop;
		this.pozoriste = pozoriste;
		this.film = film;
		this.predstava = predstava;
		this.korisnik = korisnik;
		this.datum = datum;
		this.red = red;
		this.kolona = kolona;
		this.ocenaAmbijent = ocenaAmbijent;
		this.ocenaPredstavaProjekcija = ocenaPredstavaProjekcija;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	public void setPozoriste(Pozoriste pozoriste) {
		this.pozoriste = pozoriste;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Predstava getPredstava() {
		return predstava;
	}

	public void setPredstava(Predstava predstava) {
		this.predstava = predstava;
	}

	public RegistrovaniKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovaniKorisnik korisnik) {
		this.korisnik = korisnik;
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



	public Date getDatum() {
		return datum;
	}



	public void setDatum(Date datum) {
		this.datum = datum;
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
	
	

}
