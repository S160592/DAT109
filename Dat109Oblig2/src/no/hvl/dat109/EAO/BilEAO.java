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
		
		List<Bil> biler = em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
	
		return biler;
	}


	@Override
	public void leggTil(Bil bil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Bil bil) {
		// TODO Auto-generated method stub
		
	}

	
}
