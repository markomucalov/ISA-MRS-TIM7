package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.service.PozoristeService;

@RestController
public class PozoristaController {
	
	@Autowired
	private PozoristeService pozoristeService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/pozorista",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Pozoriste> getAllPozorista() {
	    return pozoristeService.getAllPozorista(new PageRequest(0, 10));
	}

}