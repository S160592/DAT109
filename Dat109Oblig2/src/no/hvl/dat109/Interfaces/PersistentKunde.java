package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.KundeEntity;

public interface PersistentKunde {
	public void leggTil(KundeEntity kunde);
	
	public KundeEntity finnKunde(String mobilnr);
	
}
