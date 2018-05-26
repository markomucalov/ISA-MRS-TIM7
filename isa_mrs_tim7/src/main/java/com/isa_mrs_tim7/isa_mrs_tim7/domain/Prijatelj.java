package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "prijatelji")
public class Prijatelj implements Serializable {
	/*-1 poslat, 2-prihvacen, 3-obrisan*/
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	String poslao;
	@Column(nullable = false)
	String prihvatio;
	@Column(nullable = false)
	int opcija;
	public Prijatelj(Long id, String poslao, String prihvatio, int opcija) {
		super();
		this.id = id;
		this.poslao = poslao;
		this.prihvatio = prihvatio;
		this.opcija = opcija;
	}
	public Prijatelj() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPoslao() {
		return poslao;
	}
	public void setPoslao(String poslao) {
		this.poslao = poslao;
	}
	public String getPrihvatio() {
		return prihvatio;
	}
	public void setPrihvatio(String prihvatio) {
		this.prihvatio = prihvatio;
	}
	public int getOpcija() {
		return opcija;
	}
	public void setOpcija(int opcija) {
		this.opcija = opcija;
	}
	
    
}
