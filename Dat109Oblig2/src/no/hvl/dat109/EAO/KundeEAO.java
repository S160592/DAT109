package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.KundeEntity;
import no.hvl.dat109.Interfaces.PersistentKunde;

@Stateless
public class KundeEAO implements PersistentKunde{
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	

	public void leggTil(KundeEntity kunde) {
		em.persist(kunde);
	}
	
	
	public KundeEntity finnKunde(String mobilnr) {
		return em.find(KundeEntity.class, mobilnr);
	}
	
	
}
