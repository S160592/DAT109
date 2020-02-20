package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Kunde;

public interface PersistentKunde {
	public void leggTil(KundeInterface kunde);
	
	public Kunde finnKunde(String mobilnr);
	
}
