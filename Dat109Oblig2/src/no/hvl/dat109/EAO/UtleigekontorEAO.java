package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.UtleigekontorDB;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@Stateless
public class UtleigekontorEAO implements PersistentUtleigekontor{
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	
	public UtleigekontorDB hentUtleigekontor(int id) {
		return em.find(UtleigekontorDB.class, id);
	}
	
	public List<UtleigekontorDB> hentAlle(){
		return em.createNamedQuery("Utleigekontor.findAll", UtleigekontorDB.class).getResultList();
	}

	
	
}
