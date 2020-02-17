package no.hvl.dat109.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the faktura database table.
 * 
 */
@Entity
@Table(name = "Faktura", schema = "borgar")
@NamedQuery(name="Faktura.findAll", query="SELECT f FROM Faktura f")
public class Faktura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer fakturanr;

	//bi-directional many-to-one association to Reservasjon
	@ManyToOne
	@JoinColumn(name="reservasjon")
	private Reservasjon reservasjonBean;

	public Faktura() {
	}

	public Integer getFakturanr() {
		return this.fakturanr;
	}

	public void setFakturanr(Integer fakturanr) {
		this.fakturanr = fakturanr;
	}

	public Reservasjon getReservasjonBean() {
		return this.reservasjonBean;
	}

	public void setReservasjonBean(Reservasjon reservasjonBean) {
		this.reservasjonBean = reservasjonBean;
	}

}