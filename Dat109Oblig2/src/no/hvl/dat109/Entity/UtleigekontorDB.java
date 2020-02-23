package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;

import no.hvl.dat109.Interfaces.Utleigekontor;

import java.util.List;


/**
 * The persistent class for the utleigekontor database table.
 * 
 */
@Entity(name = "Utleigekontor")
@Table(name = "Utleigekontor", schema = "borgar")
@NamedQuery(name="Utleigekontor.findAll", query="SELECT u FROM Utleigekontor u")
public class UtleigekontorDB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String telefonnr;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="adresse")
	private AdressDB adress;

	public UtleigekontorDB() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefonnr() {
		return this.telefonnr;
	}

	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}

	public AdressDB getAdress() {
		return this.adress;
	}

	public void setAdress(AdressDB adress) {
		this.adress = adress;
	}

}