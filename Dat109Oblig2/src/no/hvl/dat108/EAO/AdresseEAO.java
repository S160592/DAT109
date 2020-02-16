package no.hvl.dat108.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.Entity.Adress;

@Stateless
public class AdresseEAO {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	
	public Adress hentAdresse(int id) {
		return em.find(Adress.class, id);
	}
	
	public List<Adress> hentAlle(){
		return em.createNamedQuery("Adress.findAll", Adress.class).getResultList();
	}
	
}
