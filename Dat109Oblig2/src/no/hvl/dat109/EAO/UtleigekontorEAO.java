package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.UtleigekontorEntity;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@Stateless
public class UtleigekontorEAO implements PersistentUtleigekontor{
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	
	public UtleigekontorEntity hentUtleigekontor(int id) {
		return em.find(UtleigekontorEntity.class, id);
	}
	
	public List<UtleigekontorEntity> hentAlle(){
		return em.createNamedQuery("Utleigekontor.findAll", UtleigekontorEntity.class).getResultList();
	}

	
	
}
