package Test.Moc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.Entity.UtleigekontorDB;
import no.hvl.dat109.Interfaces.Adress;
import no.hvl.dat109.Interfaces.Bil;
import no.hvl.dat109.Interfaces.Biltype;
import no.hvl.dat109.Interfaces.Datalagring;
import no.hvl.dat109.Interfaces.Kunde;

public class MocDatalagring implements Datalagring {

	List<Bil> bilar = new ArrayList<Bil>();
	
	
	@Override
	public void lagreBil(Bil bil) {
		bilar.add(bil);
		
	}

	@Override
	public Bil hentBil(String regnr) {
		// TODO Auto-generated method stub
		
		return bilar.stream().filter(b -> b.getRegnr().equals(regnr)).findFirst().get();
		
	}

	@Override
	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, UtleigekontorDB fraLokasjon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lagreAdresse(Adress adress) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void lagreNyKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtleigekontorDB hentUtleigekontor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Biltype hentBiltype(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Biltype> hentBiltyper() {
		// TODO Auto-generated method stub
		return null;
	}

}
