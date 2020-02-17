package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.ReservasjonEntity;

public interface PersistentReservasjon {

	public List<ReservasjonEntity> hentAlle();
	public ReservasjonEntity hentReservasjon(int id);
	public int createReservasjon(ReservasjonEntity reservasjon);
	
}
