package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.BiltypeDB;

public interface PersistentBiltype {
	public BiltypeDB hentbiltype(String type);
	
	public List<BiltypeDB> hentAlle();
	
	
}
