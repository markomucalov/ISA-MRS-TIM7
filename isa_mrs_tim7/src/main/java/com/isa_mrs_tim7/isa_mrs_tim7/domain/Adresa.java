package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adresa")
public class Adresa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String ulica;
	
	@Column(nullable = false)
	private Integer broj;
	
	@Column(nullable = false)
	private String grad;
	
	@Column(nullable = false)
	private Integer zip;

	public Adresa() {
		
	}

	public String getUlica() {
		return ulica;
	}

	public Integer getBroj() {
		return broj;
	}

	public String getGrad() {
		return grad;
	}

	public Integer getZip() {
		return zip;
	}
}
