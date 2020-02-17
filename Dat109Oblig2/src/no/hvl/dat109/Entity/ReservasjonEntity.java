package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the reservasjon database table.
 * 
 */
@Entity
@NamedQuery(name="Reservasjon.findAll", query="SELECT r FROM Reservasjon r")
public class ReservasjonEntity implements Serializable {
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
	private BilEntity bilBean;

	//bi-directional many-to-one association to Kunde
	@ManyToOne
	@JoinColumn(name="kunde")
	private KundeEntity kundeBean;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="fralokasjon")
	private UtleigekontorEntity utleigekontor1;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="tillokasjon")
	private UtleigekontorEntity utleigekontor2;

	public ReservasjonEntity() {
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

	public BilEntity getBilBean() {
		return this.bilBean;
	}

	public void setBilBean(BilEntity bilBean) {
		this.bilBean = bilBean;
	}

	public KundeEntity getKundeBean() {
		return this.kundeBean;
	}

	public void setKundeBean(KundeEntity kundeBean) {
		this.kundeBean = kundeBean;
	}

	public UtleigekontorEntity getUtleigekontor1() {
		return this.utleigekontor1;
	}

	public void setUtleigekontor1(UtleigekontorEntity utleigekontor1) {
		this.utleigekontor1 = utleigekontor1;
	}

	public UtleigekontorEntity getUtleigekontor2() {
		return this.utleigekontor2;
	}

	public void setUtleigekontor2(UtleigekontorEntity utleigekontor2) {
		this.utleigekontor2 = utleigekontor2;
	}

}