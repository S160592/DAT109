package no.hvl.dat109.EAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Biltype;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Interfaces.PersistentKunde;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@Stateless
public class DatabehandlingEAO implements Databehandling {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	@EJB
	PersistentBil bilEAO;
	@EJB
	PersistentBiltype biltypeEAO;
	@EJB
	PersistentReservasjon reservasjonEAO;
	@EJB
	PersistentAdresse adressEAO;
	@EJB
	PersistentKunde kundeEAO;
	@EJB
	PersistentUtleigekontor utleigekontorEAO;

	@Override
	public void lagreBil(Bil bil) {
		bilEAO.leggTil(bil);
	}

	@Override
	public Bil hentBil(String regnr) {
		return bilEAO.hentBil(regnr);
	}

	@Override
	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {

		List<Reservasjon> reservasjonar = reservasjonEAO.hentAlle();
		List<Bil> bilar = bilEAO.hentAlle();
		List<String> reserverte = new ArrayList<String>();

		reservasjonar.forEach(r -> {
			if ((r.getFradato().before(fra) || r.getFradato().equals(fra))
					&& (r.getTildato().after(til) || r.getTildato().equals(til))) {

				reserverte.add(r.getBilBean().getRegnr());
			}

		});

		List<Bil> ledigeBilar = bilar.stream().filter(
				b -> !reserverte.contains(b.getRegnr()) && b.getStaarVedUtleigekontor().getId() == fraLokasjon.getId())
				.collect(Collectors.toList());

		return ledigeBilar;
	}

	@Override
	public int lagreAdresse(Adress adress) {

		return adressEAO.lagre(adress);

	}

	@Override
	public void lagreNyKunde(Kunde kunde) {

		kundeEAO.leggTil(kunde);
	}

	@Override
	public Utleigekontor hentUtleigekontor(int id) {
		// TODO Auto-generated method stub
		return utleigekontorEAO.hentUtleigekontor(id);
	}

	@Override
	public Biltype hentBiltype(String id) {
		return biltypeEAO.hentbiltype(id);
	}

	@Override
	public List<Biltype> hentBiltyper() {
		// TODO Auto-generated method stub

		return biltypeEAO.hentAlle();
	}

	@Override
	public int lagreReservasjon(Reservasjon reservasjon) {
		// TODO Auto-generated method stub
		return reservasjonEAO.createReservasjon(reservasjon);

	}

	@Override
	public Reservasjon getReservasjon(String reservasjonsnr) {
		// TODO Auto-generated method stub
		return reservasjonEAO.hentReservasjon(Integer.valueOf(reservasjonsnr));
	}

	@Override
	public List<Reservasjon> hentAlleReservasjonar() {
		// TODO Auto-generated method stub
		return reservasjonEAO.hentAlle();
	}

	@Override
	public Kunde hentKunde(String telefonnr) {
		// TODO Auto-generated method stub
		return kundeEAO.finnKunde(telefonnr);
	}

	@Override
	public List<Reservasjon> hentReservasjonarFor(Kunde kunde) {
		// TODO Auto-generated method stub
		return reservasjonEAO.hentAlle().stream().filter(r -> r.getKundeBean().getTelefonnummer().equals(kunde.getTelefonnummer())).collect(Collectors.toList());
		
		
	}

}
