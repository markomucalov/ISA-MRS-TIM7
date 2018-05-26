package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa_mrs_tim7.isa_mrs_tim7.entity.AjaxResponseBody;
import com.isa_mrs_tim7.isa_mrs_tim7.entity.LoginPodaci;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Pozoriste;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.entity.SearchCriteria;
import com.isa_mrs_tim7.isa_mrs_tim7.service.ServisLogin;









@RestController
public class LoginController  {
	private RegistrovaniKorisnik reg;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 ServisLogin userService;

	    @Autowired
	    public void setUserService(ServisLogin userService) {
	        this.userService = userService;
	    }
        
	    @PostMapping(value = "/login/provjeri")
    @ResponseBody
    public RegistrovaniKorisnik getRegistrovaniKorisnikByEmailAndLozinka( @Valid @RequestBody LoginPodaci podaci, Errors errors) {
	    	System.out.println(podaci.getEmail());
	    	System.out.println(podaci.getLozinka());
	    	if (errors.hasErrors()) {

	            System.out.println((errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(","))));

	           

	        }
	    	reg=this.userService.getKorisnik(podaci.getEmail(),podaci.getLozinka());
	       return reg;
}
	    
	    @RequestMapping(value = "/login/ulogovani",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public RegistrovaniKorisnik getAllKorisnici() {
		    return reg;
		}
	    
	    
	    @RequestMapping(value = "/korisnici",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public Page<RegistrovaniKorisnik> getAllUsers() {
		    return userService.dodajSve(PageRequest.of(0, Integer.MAX_VALUE));
		}
	    
	    @RequestMapping(
				value = "/login/ulogovani",
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public RegistrovaniKorisnik updateKorisnik(
				@RequestBody RegistrovaniKorisnik korisnik) throws Exception {
			logger.info("> updateGreeting id:{}", korisnik.getId());
			System.out.println(korisnik.toString());
			reg.setIme(korisnik.getIme());
			reg.setLozinka(korisnik.getLozinka());
			reg.setPrezime(korisnik.getPrezime());
			 RegistrovaniKorisnik updatedKorisnik = userService.update(korisnik);
			if (updatedKorisnik == null) {
				System.out.println("Nije pronadjen");
			}
			logger.info("< updateGreeting id:{}", korisnik.getId());
			return updatedKorisnik;
		}
	    
	    
	   /* @PostMapping("/login/provjeri")
	    public ResponseEntity<?> getSearchResultViaAjax(
	            @Valid @RequestBody SearchCriteria search, Errors errors) {

	        AjaxResponseBody result = new AjaxResponseBody();

	        //If error, just return a 400 bad request, along with the error message
	        if (errors.hasErrors()) {

	            result.setMsg(errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(",")));

	            return ResponseEntity.badRequest().body(result);

	        }

	        List<RegistrovaniKorisnik> users = userService.findByUserNameOrEmail(search.getUsername(),search.getPassword());
	        if (users.isEmpty()) {
	            result.setMsg("no user found!");
	        } else {
	            result.setMsg("success");
	            logger.info("> updateGreeting id:{}", search.getUsername());
	        }
	        result.setResult(users);

	        return ResponseEntity.ok(result);}*/

	   
	

}