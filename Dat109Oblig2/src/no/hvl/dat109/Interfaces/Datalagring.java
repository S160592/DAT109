package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.Utleigekontor;

public interface Datalagring {

		public void lagreBil(Bil bil);
		public Bil hentBil(String regnr);
		public List<BilDB> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon);
		
	public int lagreAdresse(AdressInterface adress);
	public void lagreNyKunde(KundeInterface kunde);
	public Utleigekontor hentUtleigekontor(int id);
	
		
}
