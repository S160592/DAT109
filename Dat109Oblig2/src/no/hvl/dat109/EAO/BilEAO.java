package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Interfaces.Bil;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Superclasses.BilSuper;

@Stateless
public class BilEAO implements PersistentBil {


	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public BilDB hentBil(String regnr) {
		return em.find(BilDB.class, regnr);
	}

	public List<? extends BilSuper> hentAlle() {
		
		List<BilDB> biler = em.createNamedQuery("Bil.findAll", BilDB.class).getResultList();
	
		return biler;
	}


	public void leggTil(BilSuper bil) {
		em.persist(bil);
	}

	public void update(BilSuper bil) {
		em.merge(bil);
	}

	
}
