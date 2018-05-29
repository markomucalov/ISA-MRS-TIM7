package com.isa_mrs_tim7.isa_mrs_tim7.dto;

public class SedisteDTO {
	
	private Integer red;
	private Integer kolona;
	private String tip;
	
	public SedisteDTO(Integer red, Integer kolona, String tip) {
		super();
		this.red = red;
		this.kolona = kolona;
		this.tip = tip;
	}
	
	

	public SedisteDTO() {
		super();
	}



	public Integer getRed() {
		return red;
	}

	public void setRed(Integer red) {
		this.red = red;
	}

	public Integer getKolona() {
		return kolona;
	}

	public void setKolona(Integer kolona) {
		this.kolona = kolona;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	

}
