package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bioskop")
public class Bioskop implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(nullable = false)
    private String naziv;

	@Column(nullable = false)
    private Integer rejting;

	@OneToOne(optional = false)
    private Adresa adresa;
	
	@OneToMany(mappedBy="bioskop")
	@JsonManagedReference
	private List<Film> filmovi;
	
	@Column(nullable = false)
	private String promotivniOpis;

	public Bioskop() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getRejting() {
		return rejting;
	}

	public void setRejting(Integer rejting) {
		this.rejting = rejting;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public List<Film> getFilmovi() {
		return filmovi;
	}

	public void setFilmovi(List<Film> filmovi) {
		this.filmovi = filmovi;
	}

	public String getPromotivniOpis() {
		return promotivniOpis;
	}

	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
