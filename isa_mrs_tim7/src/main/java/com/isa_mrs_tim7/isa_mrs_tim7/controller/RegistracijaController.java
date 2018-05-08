package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.entity.AjaxResponseBody;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.entity.SearchCriteria;
import com.isa_mrs_tim7.isa_mrs_tim7.service.ServisLogin;
@RestController
public class RegistracijaController {
	/*
	
		private Logger logger = LoggerFactory.getLogger(this.getClass());
		 ServisLogin userService;

		    @Autowired
		    public void setUserService(ServisLogin userService) {
		        this.userService = userService;
		    }

		    @PostMapping("/registracija/provjeri")
		    public ResponseEntity<?> getSearchResultViaAjax(
		            @Valid @RequestBody RegistrovaniKorisnik search, Errors errors) throws MailException, InterruptedException {

		        AjaxResponseBody result = new AjaxResponseBody();
		        System.out.println(search.getEmail());

		        //If error, just return a 400 bad request, along with the error message
		        if (errors.hasErrors()) {

		            result.setMsg(errors.getAllErrors()
		                        .stream().map(x -> x.getDefaultMessage())
		                        .collect(Collectors.joining(",")));

		            return ResponseEntity.badRequest().body(result);

		        }

		        List<RegistrovaniKorisnik> users = userService.findByUserName(search.getEmail());
		        if (users.isEmpty()) {
		            result.setMsg("success");
		            try {
		            	userService.sendNotificaitionSync(search);
		    		}catch( Exception e ){
		    			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		    		}

		    		
		    	
		            
		        } else {
		            result.setMsg("Postoji korisnik");
		            logger.info("> updateGreeting id:{}", search.getEmail());
		        }
		        result.AddToResult(search);

		        return ResponseEntity.ok(result);

		    }
		
*/
	}
