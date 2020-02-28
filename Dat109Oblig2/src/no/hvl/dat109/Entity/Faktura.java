package no.hvl.dat109.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the faktura database table.
 * 
 */
@Entity(name = "Faktura")
@Table(name = "Faktura", schema = "borgar")
@NamedQuery(name = "Faktura.findAll", query = "SELECT f FROM Faktura f")
public class Faktura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fakturanr", updatable = false, nullable = false)
	private Integer fakturanr;

	private String beskriveslse;

	private Integer pris;
	
	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="faktura")
	private List<Reservasjon> reservasjons;

	public Faktura() {
	}

	public Integer getFakturanr() {
		return this.fakturanr;
	}

	public void setFakturanr(Integer fakturanr) {
		this.fakturanr = fakturanr;
	}

	public String getBeskriveslse() {
		return this.beskriveslse;
	}

	public void setBeskriveslse(String beskriveslse) {
		this.beskriveslse = beskriveslse;
	}

	public List<Reservasjon> getReservasjons() {
		return this.reservasjons;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}
	public int getPris() {
		return this.pris;
	}
	public void setReservasjons(List<Reservasjon> reservasjons) {
		this.reservasjons = reservasjons;
	}

	public Reservasjon addReservasjon(Reservasjon reservasjon) {
		getReservasjons().add(reservasjon);
		reservasjon.setFaktura(this);

		return reservasjon;
	}

	public Reservasjon removeReservasjon(Reservasjon reservasjon) {
		getReservasjons().remove(reservasjon);
		reservasjon.setFaktura(null);

		return reservasjon;
	}

}