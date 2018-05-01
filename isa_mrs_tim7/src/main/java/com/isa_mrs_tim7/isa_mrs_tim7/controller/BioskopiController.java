package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.service.BioskopService;

@RestController
public class BioskopiController {

	@Autowired
	private BioskopService bioskopService;
	
	@RequestMapping(value = "/bioskopi",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Bioskop> getAllBioskopi() {
	    return bioskopService.getAllBioskopi(PageRequest.of(0, 10));
	}
}
