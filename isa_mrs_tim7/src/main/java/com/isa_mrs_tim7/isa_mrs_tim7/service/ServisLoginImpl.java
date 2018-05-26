package com.isa_mrs_tim7.isa_mrs_tim7.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.RegistrovaniKorisnik;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.RegistrovaniKorisnikRep;


@Service
public class ServisLoginImpl implements ServisLogin {

	@Autowired
	private RegistrovaniKorisnikRep registrovaniKorisnikRep;
	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;
	
	public void sendNotificaitionSync(RegistrovaniKorisnik user) throws MailException, InterruptedException {

		
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");
        
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
		mail.setText("Pozdrav " + user.getIme() +" "+user.getPrezime()+ ",\n\nhvala što koristite našu aplikaciju. Vaša lozinka je "+user.getLozinka());
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	@Override
	public RegistrovaniKorisnik getKorisnik(String email, String lozinka) {
		// TODO Auto-generated method stub
		Assert.notNull(email, "Email ne sme biti null");
		Assert.notNull(lozinka, "Lozinka ne sme biti null");
		System.out.println(email);
		
		RegistrovaniKorisnik kor =this.registrovaniKorisnikRep.findByEmailAndLozinka(email, lozinka);
		System.out.println(kor.getIme());
		return kor;
	}

	@Override
	public RegistrovaniKorisnik update(RegistrovaniKorisnik reg) {
		
		Assert.notNull(reg.getIme(), "Ime ne sme biti null");
		Assert.notNull(reg.getPrezime(), "Prezime ne sme biti null");
		
		Assert.notNull(reg.getEmail(), "Email ne sme biti null");
		Assert.notNull(reg.getLozinka(), "Lozinka ne sme biti null");
		Optional<RegistrovaniKorisnik> kor=this.registrovaniKorisnikRep.findByEmail(reg.getEmail());
		if(kor.isPresent()){
			this.registrovaniKorisnikRep.save(reg);
			return reg;
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
	
	
	
	@Override
	public RegistrovaniKorisnik provjera(RegistrovaniKorisnik reg) {
		Assert.notNull(reg.getIme(), "Ime ne sme biti null");
		Assert.notNull(reg.getPrezime(), "Prezime ne sme biti null");
		
		Assert.notNull(reg.getEmail(), "Email ne sme biti null");
		Assert.notNull(reg.getLozinka(), "Lozinka ne sme biti null");
		Optional <RegistrovaniKorisnik> kor=this.registrovaniKorisnikRep.findByEmail(reg.getEmail());
		
		if(kor.isPresent()){
			return reg;
			
		}
		reg.setLozinka(generateString());
		try {
			sendNotificaitionSync(reg);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(reg.toString());
		
		RegistrovaniKorisnik r= this.registrovaniKorisnikRep.save(reg);
		return null;
	}
	@Override
	public Page<RegistrovaniKorisnik> dodajSve(Pageable page) {
		// TODO Auto-generated method stub
		return registrovaniKorisnikRep.findAll(page);
	}
	

}