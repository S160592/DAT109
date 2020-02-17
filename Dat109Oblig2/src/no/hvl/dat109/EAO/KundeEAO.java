package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Interfaces.PersistentKunde;

@Stateless
public class KundeEAO implements PersistentKunde {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public void leggTil(Kunde kunde) {
		
		
			em.persist(kunde);
		

	}

	public Kunde finnKunde(String mobilnr) {
		return em.find(Kunde.class, mobilnr);
	}

}
