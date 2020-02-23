package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.AdressDB;
import no.hvl.dat109.Interfaces.Adress;
import no.hvl.dat109.Interfaces.PersistentAdresse;

@Stateless
public class AdresseEAO implements PersistentAdresse {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public AdressDB hentAdresse(int id) {
		return em.find(AdressDB.class, id);
	}

	public List<AdressDB> hentAlle() {
		return em.createNamedQuery("Adress.findAll", AdressDB.class).getResultList();
	}

	@Override
	public int lagre(Adress adress) {
		em.persist(adress);

		em.flush();
		return adress.getId();

	}

}
