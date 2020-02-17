package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Interfaces.PersistentBil;

@Stateless
public class BilEAO implements PersistentBil {

	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public Bil hentBil(String regnr) {
		return em.find(Bil.class, regnr);
	}

	public List<Bil> hentAlle() {
		return em.createNamedQuery("BilEntity.findAll", Bil.class).getResultList();
	}

	public void leggTil(Bil bil) {
		em.persist(bil);
	}




	
}
