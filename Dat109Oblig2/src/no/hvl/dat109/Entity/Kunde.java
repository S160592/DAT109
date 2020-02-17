package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;


/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity
@NamedQuery(name="Kunde.findAll", query="SELECT k FROM Kunde k")
public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Expose
	private String telefonnummer;
	@Expose
	private String etternavn;
	@Expose
	private String fornavn;
	

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="adresse")
	private  Adress adress;

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="kundeBean")
	private  List<Reservasjon> reservasjons;

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

	


	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Reservasjon> getReservasjons() {
		return this.reservasjons;
	}

	public void setReservasjons(List<Reservasjon> reservasjons) {
		this.reservasjons = reservasjons;
	}

	public Reservasjon addReservasjon(Reservasjon reservasjon) {
		getReservasjons().add(reservasjon);
		reservasjon.setKundeBean(this);

		return reservasjon;
	}

	public Reservasjon removeReservasjon(Reservasjon reservasjon) {
		getReservasjons().remove(reservasjon);
		reservasjon.setKundeBean(null);

		return reservasjon;
	}



	
	public Adress getAdress() {
		// TODO Auto-generated method stub
		return this.adress;
	}

}