package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@Stateless
public class UtleigekontorEAO implements PersistentUtleigekontor{
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	
	public Utleigekontor hentUtleigekontor(int id) {
		return em.find(Utleigekontor.class, id);
	}
	
	public List<Utleigekontor> hentAlle(){
		return em.createNamedQuery("Utleigekontor.findAll", Utleigekontor.class).getResultList();
	}

	@Override
	public void nyttUtleigekontor(Utleigekontor utleigekontor) {
		em.persist(utleigekontor);
	}

	
	
}
