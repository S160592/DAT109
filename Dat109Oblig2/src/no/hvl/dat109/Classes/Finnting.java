package no.hvl.dat109.Classes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Interfaces.PersistentKunde;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@Stateless
public class Finnting {

	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public Finnting() {

	}

	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {

		List<Reservasjon> reservasjonar = em.createNamedQuery("Reservasjon.findAll", Reservasjon.class).getResultList();
		List<Bil> bilar = em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
		List<String> reserverte = new ArrayList<String>();

		reservasjonar.forEach(r -> {

			if (r.getFradato().before(fra) && r.getTildato().after(til)) {
				reserverte.add(r.getBilBean().getRegnr());
			}

		});

		List<Bil> ledigeBilar = bilar.stream()
				.filter(b -> !reserverte.contains(b.getRegnr()) && b.getUtleigekontor().getId() == fraLokasjon.getId())
				.collect(Collectors.toList());
		
		return ledigeBilar;
	}

}
