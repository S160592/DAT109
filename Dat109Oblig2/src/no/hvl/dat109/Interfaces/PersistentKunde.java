package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.KundeDB;

public interface PersistentKunde {
	public void leggTil(Kunde kunde);
	
	public KundeDB finnKunde(String mobilnr);
	
}
