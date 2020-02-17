package no.hvl.dat109.Classes;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Interfaces.PersistentKunde;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

public class Finnting {

	@EJB
	private PersistentBil bilEAO;
	@EJB
	private PersistentUtleigekontor utleigekontorEAO;
	@EJB
	private PersistentBiltype biltypeEAO;
	@EJB
	private PersistentAdresse adresseEAO;
	@EJB
	private PersistentKunde kundeEAO;
	@EJB
	private PersistentReservasjon reservasjonEAO;
	
	public Finnting() {
		
	}
	
	
	public List<Bil> finnledige(){
		
		
		List<Bil> bilar = new ArrayList<Bil>();
		
		
		List<Bil> alleBilar = bilEAO.hentAlle();
		
		List<Reservasjon> reservasjonar = reservasjonEAO.hentAlle();
		
		
		reservasjonar.forEach(x -> {
			if (alleBilar.contains(x)) {
				System.out.println(x.getBilBean().getRegnr() + " har ein reservasjon");
			}
		});
		
		
		
		return bilar;
	}
	
	
}
