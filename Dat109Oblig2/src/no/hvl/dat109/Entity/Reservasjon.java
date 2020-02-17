package no.hvl.dat109.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the reservasjon database table.
 * 
 */
@Entity
@NamedQuery(name="Reservasjon.findAll", query="SELECT r FROM Reservasjon r")
public class Reservasjon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservasjonsid", updatable = false, nullable = false)
	private Integer reservasjonsid;

	private String fradato;

	private Integer kmstandinn;

	private Integer kmstandut;

	private String tildato;

	//bi-directional many-to-one association to Bil
	@ManyToOne
	@JoinColumn(name="bil")
	private Bil bilBean;

	//bi-directional many-to-one association to Kunde
	@ManyToOne
	@JoinColumn(name="kunde")
	private Kunde kundeBean;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="fralokasjon")
	private Utleigekontor utleigekontor1;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="tillokasjon")
	private Utleigekontor utleigekontor2;

	public Reservasjon() {
	}

	public Integer getReservasjonsid() {
		return this.reservasjonsid;
	}

	public void setReservasjonsid(Integer reservasjonsid) {
		this.reservasjonsid = reservasjonsid;
	}

	public String getFradato() {
		return this.fradato;
	}

	public void setFradato(String fradato) {
		this.fradato = fradato;
	}

	public Integer getKmstandinn() {
		return this.kmstandinn;
	}

	public void setKmstandinn(Integer kmstandinn) {
		this.kmstandinn = kmstandinn;
	}

	public Integer getKmstandut() {
		return this.kmstandut;
	}

	public void setKmstandut(Integer kmstandut) {
		this.kmstandut = kmstandut;
	}

	public String getTildato() {
		return this.tildato;
	}

	public void setTildato(String tildato) {
		this.tildato = tildato;
	}

	public Bil getBilBean() {
		return this.bilBean;
	}

	public void setBilBean(Bil bilBean) {
		this.bilBean = bilBean;
	}

	public Kunde getKundeBean() {
		return this.kundeBean;
	}

	public void setKundeBean(Kunde kundeBean) {
		this.kundeBean = kundeBean;
	}

	public Utleigekontor getUtleigekontor1() {
		return this.utleigekontor1;
	}

	public void setUtleigekontor1(Utleigekontor utleigekontor1) {
		this.utleigekontor1 = utleigekontor1;
	}

	public Utleigekontor getUtleigekontor2() {
		return this.utleigekontor2;
	}

	public void setUtleigekontor2(Utleigekontor utleigekontor2) {
		this.utleigekontor2 = utleigekontor2;
	}

}