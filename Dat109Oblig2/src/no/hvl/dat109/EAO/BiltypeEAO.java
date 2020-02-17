package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.BiltypeEntity;
import no.hvl.dat109.Interfaces.PersistentBiltype;

@Stateless
public class BiltypeEAO implements PersistentBiltype {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public BiltypeEntity hentbiltype(String type) {
		return em.find(BiltypeEntity.class, type);
	}
	
	public List<BiltypeEntity> hentAlle(){
		return em.createNamedQuery("Biltype.findAll", BiltypeEntity.class).getResultList();
	}
	
}
