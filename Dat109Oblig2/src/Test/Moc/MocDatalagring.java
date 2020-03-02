package Test.Moc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Biltype;
import no.hvl.dat109.Entity.Faktura;
import no.hvl.dat109.Entity.Firma;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.Databehandling;

public class MocDatalagring implements Databehandling{

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
	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {
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
	public Utleigekontor hentUtleigekontor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Biltype hentBiltype(String biltype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Biltype> hentBiltyper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lagreReservasjon(Reservasjon reservasjon) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reservasjon getReservasjon(String reservasjonsnr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservasjon> hentAlleReservasjonar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kunde hentKunde(String telefonnr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservasjon> hentReservasjonarFor(Kunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nyttUtleigekontor(Utleigekontor utleigekontor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Firma hentFirma() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faktura> hentAlleFaktura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nyFaktura(Faktura faktura) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Faktura getFaktura(int fakturanr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void oppdaterKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void oppdaterReservasjon(Reservasjon reservasjon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utleigekontor> hentAlleUtleigekontor() {
		// TODO Auto-generated method stub
		return null;
	}


}
