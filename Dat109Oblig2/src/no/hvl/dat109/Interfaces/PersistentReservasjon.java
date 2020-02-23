package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.ReservasjonDB;

public interface PersistentReservasjon {

	public List<ReservasjonDB> hentAlle();
	public ReservasjonDB hentReservasjon(int id);
	public int createReservasjon(ReservasjonDB reservasjon);
	
}
