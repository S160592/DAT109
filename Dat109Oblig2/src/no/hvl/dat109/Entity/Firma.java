package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the firma database table.
 * 
 */
@Entity(name = "Firma")
@Table(name = "Firma", schema = "borgar")
@NamedQuery(name="Firma.findAll", query="SELECT f FROM Firma f")
public class Firma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String navn;

	private Integer adresse;

	//bi-directional many-to-one association to Utleigekontor
	@OneToMany(mappedBy="firmaBean")
	private List<UtleigekontorDB> utleigekontors;

	public Firma() {
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Integer adresse) {
		this.adresse = adresse;
	}

	public List<UtleigekontorDB> getUtleigekontors() {
		return this.utleigekontors;
	}

	public void setUtleigekontors(List<UtleigekontorDB> utleigekontors) {
		this.utleigekontors = utleigekontors;
	}

	

}