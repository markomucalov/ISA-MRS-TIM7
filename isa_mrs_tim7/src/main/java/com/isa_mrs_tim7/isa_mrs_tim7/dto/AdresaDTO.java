package com.isa_mrs_tim7.isa_mrs_tim7.dto;

public class AdresaDTO {

	private String ulica;
	private String broj;
	private String grad;
	private Integer zip;

	public AdresaDTO() {
		
	}

	public AdresaDTO(String ulica, String broj, String grad, Integer zip) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		this.grad = grad;
		this.zip = zip;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
}
