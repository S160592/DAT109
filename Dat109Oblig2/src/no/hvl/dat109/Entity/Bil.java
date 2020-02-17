package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
	private Utleigekontor utleigekontor;

	// bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy = "bilBean")
	private List<Reservasjon> reservasjons;

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

	public void setBiltype(Biltype biltype) {
		this.biltype = biltype;
	}

	public Utleigekontor getUtleigekontor() {
		return this.utleigekontor;
	}

	public void setUtleigekontor(Utleigekontor utleigekontor) {
		this.utleigekontor = utleigekontor;
	}

	public List<Reservasjon> getReservasjons() {
		return this.reservasjons;
	}

	public void setReservasjons(List<Reservasjon> reservasjons) {
		this.reservasjons = reservasjons;
	}

	public Reservasjon addReservasjon(Reservasjon reservasjon) {
		getReservasjons().add(reservasjon);
		reservasjon.setBilBean(this);

		return reservasjon;
	}

	public Reservasjon removeReservasjon(Reservasjon reservasjon) {
		getReservasjons().remove(reservasjon);
		reservasjon.setBilBean(null);

		return reservasjon;
	}

	@Override
	public String toString() {
		return "Bil [regnr=" + regnr + ", farge=" + farge + ", merke=" + merke + "]";
	}
	
	

}