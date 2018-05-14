package com.isa_mrs_tim7.isa_mrs_tim7.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pozoriste")
@EntityListeners(AuditingEntityListener.class)
public class Pozoriste implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String naziv;

	@Column(nullable = false)
	private Integer rejting;

	@OneToOne(optional = false)
	private Adresa adresa;

	@OneToMany(mappedBy="pozoriste")
	@JsonManagedReference
	private List<Predstava> predstave;
	
	@Column(nullable = false)
	private String promotivniOpis;
    
    public Pozoriste() {
    	
    }
    
    public Pozoriste(String naziv, Integer rejting, Adresa adresa) {
		super();
		this.naziv = naziv;
		this.rejting = rejting;
		this.adresa = adresa;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getRejting() {
		return rejting;
	}
	
	public void setRejting(Integer rejting) {
		this.rejting = rejting;
	}

	public Adresa getAdresa() {
		return adresa;
	}
	
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public List<Predstava> getPredstave() {
		return predstave;
	}

	public void setPredstave(List<Predstava> predstave) {
		this.predstave = predstave;
	}

	public String getPromotivniOpis() {
		return promotivniOpis;
	}

	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
