package no.hvl.dat108.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.Entity.Kunde;

@Stateless
public class KundeEAO {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	

	public void leggTil(Kunde kunde) {
		em.persist(kunde);
	}
	
	
	public Kunde finnKunde(String mobilnr) {
		return em.find(Kunde.class, mobilnr);
	}
	
	
}
