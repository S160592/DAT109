package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.ReservasjonEntity;
import no.hvl.dat109.Interfaces.PersistentReservasjon;

@Stateless
public class ReservasjonEAO implements PersistentReservasjon {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public List<ReservasjonEntity> hentAlle() {
		return em.createNamedQuery("Reservasjon.findAll", ReservasjonEntity.class).getResultList();
	}
	
	public ReservasjonEntity hentReservasjon(int id) {
		return em.find(ReservasjonEntity.class, id);
	}
	
	public int createReservasjon(ReservasjonEntity reservasjon) {
		em.persist(reservasjon);
		em.flush();
		return reservasjon.getReservasjonsid();
	}
}
