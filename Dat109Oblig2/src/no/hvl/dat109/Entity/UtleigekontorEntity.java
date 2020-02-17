package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utleigekontor database table.
 * 
 */
@Entity
@NamedQuery(name="Utleigekontor.findAll", query="SELECT u FROM Utleigekontor u")
public class UtleigekontorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer id;

	private String telefonnr;


	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="adresse")
	private AdressEntity adress;

	public UtleigekontorEntity() {
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


	public AdressEntity getAdress() {
		return this.adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

}