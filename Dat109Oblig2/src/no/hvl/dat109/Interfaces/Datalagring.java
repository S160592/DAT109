package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.UtleigekontorDB;
import no.hvl.dat109.Superclasses.BilSuper;
import no.hvl.dat109.Superclasses.BiltypeSuper;

public interface Datalagring {

	public void lagreBil(BilSuper bil);

	public Bil hentBil(String regnr);

	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, UtleigekontorDB fraLokasjon);

	public int lagreAdresse(Adress adress);

	public void lagreNyKunde(Kunde kunde);

	public UtleigekontorDB hentUtleigekontor(int id);
	public BiltypeSuper hentBiltype(String biltype);
	public List<? extends Biltype> hentBiltyper();

}
