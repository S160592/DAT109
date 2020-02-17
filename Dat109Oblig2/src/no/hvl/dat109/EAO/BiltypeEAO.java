package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Biltype;
import no.hvl.dat109.Interfaces.PersistentBiltype;

@Stateless
public class BiltypeEAO implements PersistentBiltype {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public Biltype hentbiltype(String type) {
		return em.find(Biltype.class, type);
	}
	
	public List<Biltype> hentAlle(){
		return em.createNamedQuery("Biltype.findAll", Biltype.class).getResultList();
	}
	
	
	
}
