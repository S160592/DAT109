package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Kunde;

public interface PersistentKunde {
	public void leggTil(Kunde kunde);
	
	public Kunde finnKunde(String mobilnr);
	
}
