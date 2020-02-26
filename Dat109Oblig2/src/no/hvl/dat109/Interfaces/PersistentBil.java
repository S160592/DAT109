package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Superclasses.BilSuper;

public interface PersistentBil {


	public BilDB hentBil(String regnr);
	public List<? extends BilSuper> hentAlle();
	public void leggTil(BilSuper bil);
	public void update(BilSuper bil); 
}
