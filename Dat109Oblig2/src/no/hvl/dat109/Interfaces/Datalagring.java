package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Biltype;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;

public interface Datalagring {

	public void lagreBil(Bil bil);

	public Bil hentBil(String regnr);

	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon);

	public int lagreAdresse(Adress adress);

	public void lagreNyKunde(Kunde kunde);

	public Utleigekontor hentUtleigekontor(int id);
	public Biltype hentBiltype(String biltype);
	public List<Biltype> hentBiltyper();
	public int lagreReservasjon(Reservasjon reservasjon);

}
