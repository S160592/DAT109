package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the reservasjon database table.
 * 
 */
@Entity
@Table(name = "Reservasjon", schema = "borgar")
@NamedQuery(name="Reservasjon.findAll", query="SELECT r FROM Reservasjon r")
public class Reservasjon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservasjonsid", updatable = false, nullable = false)
	private Integer reservasjonsid;

	private Timestamp fradato;

	private Integer kmstandinn;

	private Integer kmstandut;

	private Timestamp tildato;

	//bi-directional many-to-one association to Bil
	@ManyToOne
	@JoinColumn(name="bil")
	private BilDB bilBean;

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

	//bi-directional many-to-one association to Faktura
	@OneToMany(mappedBy="reservasjonBean")
	private List<Faktura> fakturas;

	public Reservasjon() {
	}

	public Integer getReservasjonsid() {
		return this.reservasjonsid;
	}

	public void setReservasjonsid(Integer reservasjonsid) {
		this.reservasjonsid = reservasjonsid;
	}

	public Timestamp getFradato() {
		return this.fradato;
	}

	public void setFradato(Timestamp fradato) {
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

	public Timestamp getTildato() {
		return this.tildato;
	}

	public void setTildato(Timestamp tildato) {
		this.tildato = tildato;
	}

	public BilDB getBilBean() {
		return this.bilBean;
	}

	public void setBilBean(BilDB bilBean) {
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

	public List<Faktura> getFakturas() {
		return this.fakturas;
	}

	public void setFakturas(List<Faktura> fakturas) {
		this.fakturas = fakturas;
	}

}