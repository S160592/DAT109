package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Biltype;

public interface PersistentBiltype {
	public Biltype hentbiltype(String type);
	
	public List<Biltype> hentAlle();
}
