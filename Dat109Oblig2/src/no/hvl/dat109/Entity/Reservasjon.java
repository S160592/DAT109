package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the reservasjon database table.
 * 
 */
@Entity(name = "Reservasjon")
@Table(name = "Reservasjon", schema = "borgar")
@NamedQuery(name = "Reservasjon.findAll", query = "SELECT r FROM Reservasjon r")
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

	// bi-directional many-to-one association to Bil
	@ManyToOne
	@JoinColumn(name = "bil")
	private Bil bil;

	// bi-directional many-to-one association to Kunde
	@ManyToOne
	@JoinColumn(name = "kunde")
	private Kunde kunde;

	// bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name = "fralokasjon")
	private Utleigekontor fraUtleigekontor;

	// bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name = "tillokasjon")
	private Utleigekontor tilUtleigekotor;
	
	@JoinColumn(name="fakturaid")
	private Faktura faktura;
	

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

	public Bil getBilBean() {
		return this.bil;
	}

	public void setBilBean(Bil bilBean) {
		this.bil = bilBean;
	}

	public Kunde getKundeBean() {
		return this.kunde;
	}

	public void setKundeBean(Kunde kundeBean) {
		this.kunde = kundeBean;
	}

	public Utleigekontor getFraUtleigekontor() {
		return this.fraUtleigekontor;
	}

	public void setFraUtleigekontor(Utleigekontor fraUtleigekotor) {
		this.fraUtleigekontor = fraUtleigekotor;
	}

	public Utleigekontor getTilUtleigekotor() {
		return this.tilUtleigekotor;
	}

	public void setTilUtleigekotor(Utleigekontor tilUtleigekotor) {
		this.tilUtleigekotor = tilUtleigekotor;
	}

	public Faktura getFaktura() {
		return this.faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}
	
	

	@Override
	public String toString() {
		return "Reservasjon [reservasjonsid=" + reservasjonsid + ", fradato=" + fradato + ", tildato=" + tildato + "]";
	}

}