package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Biltype;
import no.hvl.dat109.Entity.Faktura;
import no.hvl.dat109.Entity.Firma;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;

public interface Databehandling {

	public void lagreBil(Bil bil);

	public Bil hentBil(String regnr);

	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon);

	public int lagreAdresse(Adress adress);

	public void lagreNyKunde(Kunde kunde);

	public Utleigekontor hentUtleigekontor(int id);

	public Biltype hentBiltype(String biltype);

	public List<Biltype> hentBiltyper();

	public int lagreReservasjon(Reservasjon reservasjon);

	public Reservasjon getReservasjon(String reservasjonsnr);

	public List<Reservasjon> hentAlleReservasjonar();

	public Kunde hentKunde(String telefonnr);

	public List<Reservasjon> hentReservasjonarFor(Kunde kunde);

	public void nyttUtleigekontor(Utleigekontor utleigekontor);

	public Firma hentFirma();


	public List<Faktura> hentAlleFaktura();
	
	public int nyFaktura(Faktura faktura);
	
	public Faktura getFaktura(int fakturanr);
	
	public void oppdaterKunde(Kunde kunde);
	
	public void oppdaterReservasjon(Reservasjon reservasjon);

}
