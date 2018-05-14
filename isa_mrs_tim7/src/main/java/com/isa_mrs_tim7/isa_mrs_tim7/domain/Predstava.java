package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "predstava")
public class Predstava implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String naizv;
	
	@ElementCollection
	private List<String> spisakGlumaca;
	
	@Column(nullable = false)
	private String zanr;
	
	@Column(nullable = false)
	private String imeReditelja;
	
	@Column(nullable = false)
	private Time trajanje;
	
	@Column(nullable = false)
	private byte[] slika;
	
	@Column(nullable = false)
	private String opis;
	
	@ElementCollection
	private List<Integer> ocene;

	@ManyToOne
	@JoinColumn(name="pozoriste_id", nullable=false, unique=false)
	@JsonBackReference
	private Pozoriste pozoriste;
	
	@Column(nullable = false)
	private Integer cena;
	
	public Predstava() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Integer> getOcene() {
		return ocene;
	}

	public void setOcene(List<Integer> ocene) {
		this.ocene = ocene;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	public void setPozoriste(Pozoriste pozoriste) {
		this.pozoriste = pozoriste;
	}

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}

}
