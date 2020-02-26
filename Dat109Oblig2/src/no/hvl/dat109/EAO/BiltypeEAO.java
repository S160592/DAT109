package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.BiltypeDB;
import no.hvl.dat109.Interfaces.Biltype;
import no.hvl.dat109.Interfaces.PersistentBiltype;

@Stateless
public class BiltypeEAO implements PersistentBiltype {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public BiltypeDB hentbiltype(String type) {
		return em.find(BiltypeDB.class, type);
	}
	
	public List<BiltypeDB> hentAlle(){
		return em.createNamedQuery("Biltype.findAll", BiltypeDB.class).getResultList();
	}
	
	
	
}
