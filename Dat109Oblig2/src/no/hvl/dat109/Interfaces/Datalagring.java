package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Utleigekontor;

public interface Datalagring {

		public void lagreBil(Bil bil);
		public Bil hentBil(String regnr);
		public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon);
		
}
