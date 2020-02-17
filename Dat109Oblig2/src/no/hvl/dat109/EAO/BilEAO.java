package no.hvl.dat109.EAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.BilEntity;
import no.hvl.dat109.Interfaces.PersistentBil;

@Stateless
public class BilEAO implements PersistentBil {
	
	@PersistenceContext(name = "utleige")
    private EntityManager em;

	public BilEntity hentBil(String regnr) {
		return em.find(BilEntity.class, regnr);
	}
	
	public List<BilEntity> hentAlle(){
		return em.createNamedQuery("Bil.findAll", BilEntity.class).getResultList();
	}
	
	public void leggTil(BilEntity bil) {
		em.persist(bil);
	}

}
