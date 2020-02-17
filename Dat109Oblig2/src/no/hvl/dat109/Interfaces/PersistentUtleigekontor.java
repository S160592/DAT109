package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.UtleigekontorEntity;

public interface PersistentUtleigekontor {


	public UtleigekontorEntity hentUtleigekontor(int id);
	public List<UtleigekontorEntity> hentAlle();
	
	
}
