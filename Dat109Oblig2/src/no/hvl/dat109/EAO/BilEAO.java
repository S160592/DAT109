package no.hvl.dat109.EAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.UtleigekontorDB;
import no.hvl.dat109.Interfaces.Bil;
import no.hvl.dat109.Interfaces.PersistentBil;

@Stateless
public class BilEAO implements PersistentBil {


	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public BilDB hentBil(String regnr) {
		return em.find(BilDB.class, regnr);
	}

	public List<? extends Bil> hentAlle() {
		
		List<BilDB> biler = em.createNamedQuery("Bil.findAll", BilDB.class).getResultList();
	
		return biler;
	}


	public void leggTil(Bil bil) {
		em.persist(bil);
	}

	public void update(BilDB bil) {
		em.merge(bil);
	}
}
