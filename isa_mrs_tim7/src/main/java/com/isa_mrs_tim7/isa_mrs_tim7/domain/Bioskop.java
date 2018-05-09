package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bioskop")
public class Bioskop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String naziv;

	@Column(nullable = false)
	private Integer rejting;

	@OneToOne(optional = false)
	private Adresa adresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setRejting(Integer rejting) {
		this.rejting = rejting;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Bioskop(String naziv, Integer rejting, Adresa adresa) {
		super();
		this.naziv = naziv;
		this.rejting = rejting;
		this.adresa = adresa;
	}

	public Bioskop() {

	}

	public String getNaziv() {
		return naziv;
	}

	public Integer getRejting() {
		return rejting;
	}

	public Adresa getAdresa() {
		return adresa;
	}

}
