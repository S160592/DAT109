package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.Utleigekontor;

public interface PersistentBil {


	public BilDB hentBil(String regnr);
	public List<BilDB> hentAlle();
	public void leggTil(Bil bil);
	public List<BilDB> henledige(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon);
	public void update(BilDB bil);
}
