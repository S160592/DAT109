package no.hvl.dat108.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.Entity.Reservasjon;

@Stateless
public class ReservasjonEAO {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public List<Reservasjon> hentAlle() {
		return em.createNamedQuery("Reservasjon.findAll", Reservasjon.class).getResultList();
	}
	
	public Reservasjon hentReservasjon(int id) {
		return em.find(Reservasjon.class, id);
	}
	
	public int createReservasjon(Reservasjon reservasjon) {
		em.persist(reservasjon);
		em.flush();
		return reservasjon.getReservasjonsid();
	}
}
