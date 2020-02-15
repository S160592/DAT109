package no.hvl.dat108.EAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.Entity.Bil;

@Stateless
public class BilEAO {
	
	@PersistenceContext(name = "utleige")
    private EntityManager em;

	public Bil hentMedlem(String mobilnr) {
		return em.find(Bil.class, mobilnr);
	}
	

	public List<Bil> hentAlle(){
		return em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
	}
	
	public void leggTil(Bil nyttMedlem) {
		em.persist(nyttMedlem);
	}

}
