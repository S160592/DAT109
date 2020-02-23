package no.hvl.dat109.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import no.hvl.dat109.Interfaces.Adress;


/**
 * The persistent class for the adress database table.
 * 
 */

@Entity(name = "Adress")
@Table(name = "Adress", schema = "borgar")
@NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
public class AdressDB implements Serializable, Adress {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	private String gateadresse;

	private String postnummer;

	private String poststed;

	

	public AdressDB() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGateadresse() {
		return this.gateadresse;
	}

	public void setGateadresse(String gateadresse) {
		this.gateadresse = gateadresse;
	}

	public String getPostnummer() {
		return this.postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public String getPoststed() {
		return this.poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}


}