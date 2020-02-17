package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.AdressEntity;
import no.hvl.dat109.Interfaces.PersistentAdresse;

@Stateless
public class AdresseEAO implements PersistentAdresse{
	@PersistenceContext(name = "utleige")
    private EntityManager em;
	
	
	public AdressEntity hentAdresse(int id) {
		return em.find(AdressEntity.class, id);
	}
	
	public List<AdressEntity> hentAlle(){
		return em.createNamedQuery("Adress.findAll", AdressEntity.class).getResultList();
	}
	
}
