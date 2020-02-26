package no.hvl.dat109.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * The persistent class for the bil database table.
 * 
 */
@Entity(name = "Bil")
@Table(name = "Bil", schema = "borgar")
@NamedQuery(name = "Bil.findAll", query = "SELECT b FROM Bil b")

public class Bil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Expose
	private String regnr;
	@Expose
	private String farge;
	@Expose
	private String merke;

	// bi-directional many-to-one association to Biltype
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Biltype biltype;

	// bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name = "staarved")
	private Utleigekontor staarved;

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

	public Biltype getBiltype() {
		return this.biltype;
	}

	public Utleigekontor getStaarVedUtleigekontor() {
		return this.staarved;
	}

	public void setBiltype(Biltype type) {
		this.biltype = type;
	}

	public void setStaarVedUtleigekontor(Utleigekontor utleigekontor) {
		this.staarved = utleigekontor;
	}

	@Override
	public String toString() {
		return "Bil [regnr=" + regnr + ", farge=" + farge + ", merke=" + merke + ", biltype= " + biltype.getTypeid()
				+ "]";
	}

}