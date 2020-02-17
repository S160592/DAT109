package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.BilEntity;

public interface PersistentBil {


	public BilEntity hentBil(String regnr);
	public List<BilEntity> hentAlle();
	public void leggTil(BilEntity bil);
	
}
