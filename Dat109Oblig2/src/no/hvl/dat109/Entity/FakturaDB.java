package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;

import no.hvl.dat109.Interfaces.Faktura;


/**
 * The persistent class for the faktura database table.
 * 
 */
@Entity(name = "Faktura")
@Table(name = "Faktura", schema = "borgar")
@NamedQuery(name="Faktura.findAll", query="SELECT f FROM Faktura f")
public class FakturaDB implements Serializable, Faktura {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer fakturanr;

	//bi-directional many-to-one association to Reservasjon
	@ManyToOne
	@JoinColumn(name="reservasjon")
	private ReservasjonDB reservasjonBean;

	public FakturaDB() {
	}

	public Integer getFakturanr() {
		return this.fakturanr;
	}

	public void setFakturanr(Integer fakturanr) {
		this.fakturanr = fakturanr;
	}

	public ReservasjonDB getReservasjonBean() {
		return this.reservasjonBean;
	}

	public void setReservasjonBean(ReservasjonDB reservasjonBean) {
		this.reservasjonBean = reservasjonBean;
	}

}