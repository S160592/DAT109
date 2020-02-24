package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.UtleigekontorDB;

public interface Datalagring {

	public void lagreBil(Bil bil);

	public Bil hentBil(String regnr);

	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, UtleigekontorDB fraLokasjon);

	public int lagreAdresse(Adress adress);

	public void lagreNyKunde(Kunde kunde);

	public UtleigekontorDB hentUtleigekontor(int id);

}
