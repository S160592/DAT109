package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import no.hvl.dat109.Entity.Faktura;
import no.hvl.dat109.Interfaces.PersistentFaktura;

@Stateless
public class FakturaEAO implements PersistentFaktura {
	@PersistenceContext(name = "utleige")
	private EntityManager em;

	
	@Override
	public List<Faktura> hentAlleFaktura() {
		return em.createNamedQuery("Faktura.FindAll", Faktura.class).getResultList();
	}
	

	@Override
	public int nyFaktura(Faktura faktura) {
		// TODO Auto-generated method stub
		em.persist(faktura);
		em.flush();
		return faktura.getFakturanr();
	}

	@Override
	public Faktura getFaktura(int fakturanr) {
		// TODO Auto-generated method stub
		return em.find(Faktura.class, fakturanr);
	}
}
