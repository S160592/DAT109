package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Reservasjon;

public interface PersistentReservasjon {

	public List<Reservasjon> hentAlle();

	public Reservasjon hentReservasjon(int id);

	public int createReservasjon(Reservasjon reservasjon);

	public void oppdaterReservasjon(Reservasjon reservasjon);

}
