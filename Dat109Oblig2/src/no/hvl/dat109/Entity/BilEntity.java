package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bil database table.
 * 
 */
@Entity
@NamedQuery(name="Bil.findAll", query="SELECT b FROM Bil b")
public class BilEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String regnr;

	//bi-directional many-to-one association to Biltype
	@ManyToOne
	@JoinColumn(name="typeid")
	private BiltypeEntity biltype;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="staarved")
	private UtleigekontorEntity staarved;

	public UtleigekontorEntity getStaarved() {
		return staarved;
	}

	public void setStaarved(UtleigekontorEntity staarved) {
		this.staarved = staarved;
	}

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="bilBean")
	private List<ReservasjonEntity> reservasjons;

	public BilEntity() {
	}

	public String getRegnr() {
		return this.regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public BiltypeEntity getBiltype() {
		return this.biltype;
	}

	public void setBiltype(BiltypeEntity biltype) {
		this.biltype = biltype;
	}


}