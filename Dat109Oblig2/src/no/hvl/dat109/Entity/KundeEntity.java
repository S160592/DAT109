package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity
@NamedQuery(name="Kunde.findAll", query="SELECT k FROM Kunde k")
public class KundeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String telefonnummer;

	private String etternavn;

	private String fornavn;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="adresse")
	private AdressEntity adress;

	public KundeEntity() {
	}

	public String getTelefonnummer() {
		return this.telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getEtternavn() {
		return this.etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return this.fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public AdressEntity getAdress() {
		return this.adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}


}