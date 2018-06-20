package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.TerminPredstaveProjekcije;
import com.isa_mrs_tim7.isa_mrs_tim7.service.TerminPredstaveProjekcijeService;


@RestController
public class TerminPredstaveProjekcijeController {
   
	@Autowired
	private TerminPredstaveProjekcijeService terminService;
	
	
	
	@RequestMapping(value = "/repertoariPrikaz", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TerminPredstaveProjekcije> getAllBioskopi() {
		return terminService.findAll();	
	
	}
}
