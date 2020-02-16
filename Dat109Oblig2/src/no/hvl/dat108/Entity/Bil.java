package no.hvl.dat108.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bil database table.
 * 
 */
@Entity
@NamedQuery(name="Bil.findAll", query="SELECT b FROM Bil b")
public class Bil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String regnr;

	//bi-directional many-to-one association to Biltype
	@ManyToOne
	@JoinColumn(name="typeid")
	private Biltype biltype;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="staarved")
	private Utleigekontor staarved;

	public Utleigekontor getStaarved() {
		return staarved;
	}

	public void setStaarved(Utleigekontor staarved) {
		this.staarved = staarved;
	}

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="bilBean")
	private List<Reservasjon> reservasjons;

	public Bil() {
	}

	public String getRegnr() {
		return this.regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public Biltype getBiltype() {
		return this.biltype;
	}

	public void setBiltype(Biltype biltype) {
		this.biltype = biltype;
	}


}