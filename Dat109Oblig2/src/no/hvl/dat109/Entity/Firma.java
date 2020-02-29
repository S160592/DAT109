package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	
	private String telefonnr;

	


	//bi-directional many-to-one association to Utleigekontor
	@OneToMany(mappedBy="firma")
	private List<Utleigekontor> utleigekontors;

	public Firma() {
	}

	public String getNavn() {
		return this.navn;
	}


	public Integer getAdresse() {
		return this.adresse;
	}


	public List<Utleigekontor> getUtleigekontors() {
		return this.utleigekontors;
	}
	public String getTelefonnr() {
		return telefonnr;
	}

	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}

	

}