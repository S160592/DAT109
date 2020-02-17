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
		return em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
	}


	public List<Bil> henledige() {
		return em.createQuery("SELECT * FROM Bil b WHERE b.regnr IN ( SELECT b2.regnr FROM Bil b2 , Reservasjon r where b2.regnr = r.bil and now() between r.fradato and r.tildato )").getResultList();
	}

	
	
	public void leggTil(Bil bil) {
		em.persist(bil);
	}




	
}
