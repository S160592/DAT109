package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.ReservasjonDB;
import no.hvl.dat109.Interfaces.PersistentReservasjon;

@Stateless
public class ReservasjonEAO implements PersistentReservasjon {
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	public List<ReservasjonDB> hentAlle() {
		return em.createNamedQuery("Reservasjon.findAll", ReservasjonDB.class).getResultList();
	}
	
	public ReservasjonDB hentReservasjon(int id) {
		return em.find(ReservasjonDB.class, id);
	}
	
	public int createReservasjon(ReservasjonDB reservasjon) {
		System.out.println("lager reservasjon");
		em.persist(reservasjon);
		em.flush();
		return reservasjon.getReservasjonsid();
	}
}
