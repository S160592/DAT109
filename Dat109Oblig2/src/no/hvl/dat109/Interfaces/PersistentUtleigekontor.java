package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Utleigekontor;

public interface PersistentUtleigekontor {


	public Utleigekontor hentUtleigekontor(int id);
	public List<Utleigekontor> hentAlle();
	public void nyttUtleigekontor(Utleigekontor utleigekontor);
	
	
}
