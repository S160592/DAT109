package no.hvl.dat109.EAO;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Utleigekontor;
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

	public List<Bil> henledige(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {

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

	public void update(Bil bil) {
		em.merge(bil);
	}
}
