package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.BiltypeDB;
import no.hvl.dat109.Interfaces.Biltype;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Superclasses.BiltypeSuper;

@Stateless
public class BiltypeEAO implements PersistentBiltype {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	@Override
	public BiltypeSuper hentbiltype(String type) {
		return em.find(BiltypeSuper.class, type);
	}
	@Override
	public List<BiltypeSuper> hentAlle(){
		return em.createNamedQuery("Biltype.findAll", BiltypeSuper.class).getResultList();
	}
	
	
	
}
