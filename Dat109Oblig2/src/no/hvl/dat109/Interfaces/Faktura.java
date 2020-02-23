package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.ReservasjonDB;

public interface Faktura {

	public Integer getFakturanr();

	public void setFakturanr(Integer fakturanr);

	public ReservasjonDB getReservasjonBean();

	public void setReservasjonBean(ReservasjonDB reservasjonBean);
}
