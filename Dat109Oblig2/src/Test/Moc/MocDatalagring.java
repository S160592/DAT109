package Test.Moc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.AdressInterface;
import no.hvl.dat109.Interfaces.BilInterface;
import no.hvl.dat109.Interfaces.BiltypeInterface;
import no.hvl.dat109.Interfaces.Datalagring;
import no.hvl.dat109.Interfaces.KundeInterface;

public class MocDatalagring implements Datalagring {

	List<BilInterface> bilar = new ArrayList<BilInterface>();
	
	
	@Override
	public void lagreBil(BilInterface bil) {
		bilar.add(bil);
		
	}

	@Override
	public BilInterface hentBil(String regnr) {
		// TODO Auto-generated method stub
		
		return bilar.stream().filter(b -> b.getRegnr().equals(regnr)).findFirst().get();
		
	}

	@Override
	public List<BilInterface> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lagreAdresse(AdressInterface adress) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void lagreNyKunde(KundeInterface kunde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utleigekontor hentUtleigekontor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BiltypeInterface hentBiltype(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends BiltypeInterface> hentBiltyper() {
		// TODO Auto-generated method stub
		return null;
	}

}
