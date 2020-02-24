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

	public List<Bil> hentAlle() {
		List<BilDB> biler = em.createNamedQuery("Bil.findAll", BilDB.class).getResultList();
		List<Bil> bilar = new ArrayList<Bil>();
		biler.forEach(bilar::add);
		
		return bilar;
	}

	public List<BilDB> henledige(Timestamp fra, Timestamp til, UtleigekontorDB fraLokasjon) {

//		List<Reservasjon>reservasjonar=reservasjonEAO.hentAlle();List<Bil>bilar=hentAlle();List<String>reserverte=new ArrayList<String>();
//
//		reservasjonar.forEach(r->{
//
//		if(r.getFradato().before(fra)&&r.getTildato().after(til)){reserverte.add(r.getBilBean().getRegnr());}
//
//		});
//
//		List<Bil>ledigeBilar=bilar.stream().filter(b->!reserverte.contains(b.getRegnr()) && b.getUtleigekontor().getId() == fraLokasjon.getId() ).collect(Collectors.toList());
//
//		return ledigeBilar;
		return null;

	}

	public void leggTil(Bil bil) {
		em.persist(bil);
	}

	public void update(BilDB bil) {
		em.merge(bil);
	}
}
