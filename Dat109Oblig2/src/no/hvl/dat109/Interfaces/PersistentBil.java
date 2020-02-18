package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Utleigekontor;

public interface PersistentBil {


	public Bil hentBil(String regnr);
	public List<Bil> hentAlle();
	public void leggTil(Bil bil);
	public List<Bil> henledige(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon);
	public void update(Bil bil);
}
