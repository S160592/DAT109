package no.hvl.dat108.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.Entity.Utleigekontor;

@Stateless
public class UtleigekontorEAO {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	
	public Utleigekontor hentUtleigekontor(int id) {
		return em.find(Utleigekontor.class, id);
	}
	
	public List<Utleigekontor> hentAlle(){
		return em.createNamedQuery("Utleigekontor.findAll", Utleigekontor.class).getResultList();
	}
	
}
