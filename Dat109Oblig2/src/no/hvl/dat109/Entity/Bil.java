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
 * The persistent class for the bil database table.
 * 
 */
@Entity
@NamedQuery(name="Bil.findAll", query="SELECT b FROM Bil b")
public class Bil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String regnr;

	private String farge;

	private String merke;

	//bi-directional many-to-one association to Biltype
	@ManyToOne
	@JoinColumn(name="typeid")
	@Expose(serialize = false, deserialize = false)
	private  Biltype biltype;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="staarved")
	@Expose(serialize = false, deserialize = false)
	private  Utleigekontor utleigekontor;

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="bilBean")
	@Expose(serialize = false, deserialize = false)
	private  List<Reservasjon> reservasjons;

	public Bil() {
	}

	public String getRegnr() {
		return this.regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public String getFarge() {
		return this.farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public String getMerke() {
		return this.merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	@Override
	public String toString() {
		return "Bil [regnr=" + regnr + ", farge=" + farge + ", merke=" + merke + "]";
	}

}