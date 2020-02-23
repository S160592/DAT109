package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.UtleigekontorDB;

public interface PersistentUtleigekontor {


	public UtleigekontorDB hentUtleigekontor(int id);
	public List<UtleigekontorDB> hentAlle();
	
	
}
