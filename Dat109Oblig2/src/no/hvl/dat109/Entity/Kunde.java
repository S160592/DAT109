package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;

import no.hvl.dat109.Interfaces.AdressInterface;
import no.hvl.dat109.Interfaces.KundeInterface;

import java.util.List;

/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity(name = "Kunde")
@Table(name = "Kunde", schema = "borgar")
@NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k")
public class Kunde implements Serializable, KundeInterface {
	private static final long serialVersionUID = 1L;

	@Id
	private String telefonnummer;

	private String etternavn;

	private String fornavn;

	private String kredittkortnr;

	// bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name = "adresse")
	private Adress adress;

	public Kunde() {
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

	public String getKredittkortnr() {
		return this.kredittkortnr;
	}

	public void setKredittkortnr(String kredittkortnr) {
		this.kredittkortnr = kredittkortnr;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

}