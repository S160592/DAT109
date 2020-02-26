package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Interfaces.PersistentAdresse;

@Stateless
public class AdresseEAO implements PersistentAdresse {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public Adress hentAdresse(int id) {
		return em.find(Adress.class, id);
	}

	public List<Adress> hentAlle() {
		return em.createNamedQuery("Adress.findAll", Adress.class).getResultList();
	}

	@Override
	public int lagre(Adress adress) {
		em.persist(adress);

		em.flush();
		return adress.getId();

	}

}
