package com.isa_mrs_tim7.isa_mrs_tim7.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Adresa;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Bioskop;
import com.isa_mrs_tim7.isa_mrs_tim7.domain.Film;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.AdresaRep;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.BioskopRep;
import com.isa_mrs_tim7.isa_mrs_tim7.repository.FilmRep;

@Service
public class BioskopServiceImpl implements BioskopService {

	@Autowired
	private BioskopRep bioskopRep;
	
	@Autowired
	private FilmRep filmRep;

	@Autowired
	private AdresaRep adresaRep;

	@Override
	public Page<Bioskop> getAllBioskopi(Pageable pageable) {

		return bioskopRep.findAll(pageable);
	}
	
	@Override
	public Bioskop findByNaziv(String naziv) {
		return bioskopRep.findOneByNaziv(naziv);
	}
	
	@Override
	public Page<Film> getFilmovi(Bioskop bioskop, Pageable pageable) {
		Assert.notNull(bioskop, "Bioskop ne sme biti null");
		return filmRep.findByBioskop(bioskop, pageable);
	}
	
	@Override
	public Bioskop save(Bioskop bioskop) {
		return bioskopRep.save(bioskop);
	}

	@Override
	public Bioskop unesiBioskop(Bioskop bioskop) {
		// TODO Auto-generated method stub

		System.out.println(bioskop.getNaziv());
		Optional <Adresa> pronadjenaAdresa = this.adresaRep.findByUlicaAndBrojAndGrad(bioskop.getAdresa().getUlica(), bioskop.getAdresa().getBroj(), bioskop.getAdresa().getGrad());
		System.out.println(bioskop.getAdresa());
		if(!pronadjenaAdresa.isPresent()){
			this.adresaRep.save(bioskop.getAdresa());
			return this.bioskopRep.save(bioskop);
		}
		
		return null;
	}

	@Override
	public void obrisiBioskop(Bioskop bioskop) {
		//this.bioskopRep.delete(bioskop);		
	}

//>>>>>>> refs/remotes/origin/master
}
