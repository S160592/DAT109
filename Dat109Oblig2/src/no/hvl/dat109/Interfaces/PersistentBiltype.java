package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.BiltypeDB;
import no.hvl.dat109.Superclasses.BiltypeSuper;

public interface PersistentBiltype {
	public BiltypeSuper hentbiltype(String type);
	
	public List<BiltypeSuper> hentAlle();
	
	
}
