package no.hvl.dat109.EAO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hsqldb.lib.Collection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.PersistentBil;

@Stateless
public class BilEAO implements PersistentBil {

	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public Bil hentBil(String regnr) {
		return em.find(Bil.class, regnr);
	}

	public List<Bil> hentAlle() {
		return em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
	}


	public List<Bil> henledige() {

		
		
		List<Bil> bilar = em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
		List<Bil> ledige = bilar.stream().filter(x -> x.getReservasjons().size() == 0).collect(Collectors.toList()); 
		return ledige;
	}

	
	
	public void leggTil(Bil bil) {
		em.persist(bil);
	}




	
}
