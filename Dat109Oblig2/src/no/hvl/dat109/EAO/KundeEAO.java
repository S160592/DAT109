package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.KundeDB;
import no.hvl.dat109.Interfaces.Kunde;
import no.hvl.dat109.Interfaces.PersistentKunde;

@Stateless
public class KundeEAO implements PersistentKunde {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	

	public KundeDB finnKunde(String mobilnr) {
		return em.find(KundeDB.class, mobilnr);
	}

	@Override
	public void leggTil(Kunde kunde) {
		// TODO Auto-generated method stub
		em.persist(kunde);
	}

}
