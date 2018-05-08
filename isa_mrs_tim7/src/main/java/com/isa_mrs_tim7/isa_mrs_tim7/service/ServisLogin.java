package com.isa_mrs_tim7.isa_mrs_tim7.service;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.*;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


public interface ServisLogin {
	
	RegistrovaniKorisnik getKorisnik(String email1, String lozinka1);
	
	/*private List<RegistrovaniKorisnik> users;
	@Autowired
    private RegKorisnikRep rep;

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 *//*
	@Autowired
	private Environment env;
	
	public void sendNotificaitionSync(RegistrovaniKorisnik user) throws MailException, InterruptedException {

		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");
        
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getIme() +" "+user.getPrezime()+ ",\n\nhvala što koristite našu aplikaciju.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
    public List<RegistrovaniKorisnik> findByUserNameOrEmail(String username, String password) {

        List<RegistrovaniKorisnik> result = users.stream()
            .filter(x -> x.getEmail().equalsIgnoreCase(username) )
            .collect(Collectors.toList());
        for (RegistrovaniKorisnik loginPodaci : result) {
        	if( loginPodaci.getLozinka().equals(password)){
        		return result;
        	}
			
		}

       result.clear();
       return result;

    }
    public List<RegistrovaniKorisnik> findByUserName(String username) {
        //System.out.println( "User: "+username);
        List<RegistrovaniKorisnik> result = users.stream()
            .filter(x -> x.getEmail().equalsIgnoreCase(username) )
            .collect(Collectors.toList());
        
        	if( result.isEmpty()){
        		result.clear();
        	       return result;
        		
        	
		}

        	return result;

    }
    
    @PostConstruct
    private void iniDataForTesting() {

        users = rep.findAllUsers();

    }*/

}
