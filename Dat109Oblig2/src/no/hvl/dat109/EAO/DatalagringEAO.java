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
import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.Bil;
import no.hvl.dat109.Interfaces.Datalagring;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
@Stateless
public class DatalagringEAO implements Datalagring{
	@PersistenceContext(name = "utleige")
    private EntityManager em;

	@EJB
	PersistentBil bilEAO;
	@EJB
	PersistentReservasjon reservasjonEAO;
	
	@EJB
	PersistentAdresse adressEAO;
	
	
	public void lagreBil(Bil bil) {
		bilEAO.leggTil(bil);
	}

	
	public BilDB hentBil(String regnr) {
		return bilEAO.hentBil(regnr);
	}
	
	
	public List<BilDB> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {

		List<Reservasjon> reservasjonar = reservasjonEAO.hentAlle();
		List<BilDB> bilar = bilEAO.hentAlle();
		List<String> reserverte = new ArrayList<String>();

		reservasjonar.forEach(r -> {

			if (r.getFradato().before(fra) && r.getTildato().after(til)) {
				reserverte.add(r.getBilBean().getRegnr());
			}

		});

		List<BilDB> ledigeBilar = bilar.stream()
				.filter(b -> !reserverte.contains(b.getRegnr()) && b.getUtleigekontor().getId() == fraLokasjon.getId())
				.collect(Collectors.toList());
		
		return ledigeBilar;
	}


	@Override
	public void lagreAdresse(Adress adress) {
		adressEAO.lagre(adress);
		
	}
}
