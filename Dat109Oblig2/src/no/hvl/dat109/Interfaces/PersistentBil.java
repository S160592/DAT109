package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Bil;

public interface PersistentBil {


	public Bil hentBil(String regnr);
	public List<Bil> hentAlle();
	public void leggTil(Bil bil);
	public void update(Bil bil); 
}
