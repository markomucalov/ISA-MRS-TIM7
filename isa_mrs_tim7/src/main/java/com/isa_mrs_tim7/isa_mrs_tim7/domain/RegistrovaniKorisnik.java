package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regKorisnici")
public class RegistrovaniKorisnik implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	String ime;
	@Column(nullable = false)
	String prezime;
	@Column(nullable = false)
	String email;
	@Column(nullable = false)
	String lozinka;
	public RegistrovaniKorisnik(String ime, String prezime, String email, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
	}
	public RegistrovaniKorisnik() {
		
	}
	public String getIme() {
		return ime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id= id;
	}
	
	@Override
	public String toString() {
		return "RegistrovaniKorisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email
				+ ", lozinka=" + lozinka + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

}
