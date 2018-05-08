package com.isa_mrs_tim7.isa_mrs_tim7.entity;

import java.util.ArrayList;
import java.util.List;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;

public class AjaxResponseBody {
	String msg;
    List<RegistrovaniKorisnik> result=new ArrayList<RegistrovaniKorisnik>();
    
	public AjaxResponseBody() {
		
	}
	public AjaxResponseBody(String msg, List<RegistrovaniKorisnik> result) {
		super();
		this.msg = msg;
		this.result = result;
	}
	public void AddToResult(RegistrovaniKorisnik result) {
		this.result.add(result);}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<RegistrovaniKorisnik> getResult() {
		return result;
	}
	public void setResult(List<RegistrovaniKorisnik> result) {
		this.result = result;
	}

}
