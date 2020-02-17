package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.BiltypeEntity;

public interface PersistentBiltype {
	public BiltypeEntity hentbiltype(String type);
	
	public List<BiltypeEntity> hentAlle();
}
