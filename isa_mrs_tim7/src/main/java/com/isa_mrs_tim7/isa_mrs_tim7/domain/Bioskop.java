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
