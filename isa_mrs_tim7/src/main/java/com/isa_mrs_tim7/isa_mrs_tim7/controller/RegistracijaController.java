package com.isa_mrs_tim7.isa_mrs_tim7.controller;

import org.springframework.web.bind.annotation.RestController;
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
