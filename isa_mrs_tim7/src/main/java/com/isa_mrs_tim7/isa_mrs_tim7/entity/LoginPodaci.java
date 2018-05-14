package com.isa_mrs_tim7.isa_mrs_tim7.entity;

public class LoginPodaci {
	String email;
	String lozinka;
	
	public LoginPodaci() {
		
	}
	public LoginPodaci(String email, String lozinka) {
		super();
		this.email = email;
		this.lozinka = lozinka;
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
