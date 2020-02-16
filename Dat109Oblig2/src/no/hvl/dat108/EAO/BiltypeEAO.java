package no.hvl.dat108.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.Entity.Biltype;

@Stateless
public class BiltypeEAO {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public Biltype hentbiltype(String type) {
		return em.find(Biltype.class, type);
	}
	
	public List<Biltype> hentAlle(){
		return em.createNamedQuery("Biltype.findAll", Biltype.class).getResultList();
	}
	
}
