package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pozoriste")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Pozoriste implements Serializable {

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Pozoriste(String naziv, Integer rejting, Adresa adresa, Date createdAt, Date updatedAt) {
		super();
		this.naziv = naziv;
		this.rejting = rejting;
		this.adresa = adresa;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Pozoriste() {

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

	public String getNaziv() {
		return naziv;
	}

	public Integer getRejting() {
		return rejting;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
}
