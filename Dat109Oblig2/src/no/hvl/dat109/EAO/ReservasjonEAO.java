package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.PersistentReservasjon;

@Stateless
public class ReservasjonEAO implements PersistentReservasjon {
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

	@Override
	public void oppdaterReservasjon(Reservasjon reservasjon) {
		em.merge(reservasjon);
	}
}
