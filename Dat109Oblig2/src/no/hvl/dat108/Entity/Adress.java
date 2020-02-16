package no.hvl.dat108.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adress database table.
 * 
 */
@Entity
@NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	private String gateadresse;

	private String postnummer;

	private String poststed;

	//bi-directional many-to-one association to Kunde
	@OneToMany(mappedBy="adress")
	private List<Kunde> kundes;

	//bi-directional many-to-one association to Utleigekontor
	@OneToMany(mappedBy="adress")
	private List<Utleigekontor> utleigekontors;

	public Adress() {
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