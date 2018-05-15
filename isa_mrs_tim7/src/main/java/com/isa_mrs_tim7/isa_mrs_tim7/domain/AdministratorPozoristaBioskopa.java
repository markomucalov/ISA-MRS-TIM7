package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adminPozoristaBioskopa")
public class AdministratorPozoristaBioskopa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String ime;

	@Column(nullable = false)
	private String prezime;
	
	@Column(nullable = false)
	private String mailAdresa;
	
	@Column(nullable = false)
	private String korisnickoIme;
	
	@Column(nullable = false)
	private String lozinka;

	@OneToOne(optional = true)
    private Bioskop bioskop;
	
	@OneToOne(optional = true)
    private Pozoriste pozoriste;
	
	public AdministratorPozoristaBioskopa(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getMailAdresa() {
		return mailAdresa;
	}

	public void setMailAdresa(String mailAdresa) {
		this.mailAdresa = mailAdresa;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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
	
	
}
