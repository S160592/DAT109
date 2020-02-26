package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Reservasjon;

public interface FakturaInterface {

	public Integer getFakturanr();

	public void setFakturanr(Integer fakturanr);

	public Reservasjon getReservasjonBean();

	public void setReservasjonBean(Reservasjon reservasjonBean);
}
