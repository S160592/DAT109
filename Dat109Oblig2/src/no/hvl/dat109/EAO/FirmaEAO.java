package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Entity.Firma;
import no.hvl.dat109.Interfaces.PersistentFirma;

@Stateless
public class FirmaEAO implements PersistentFirma {



	@PersistenceContext(name = "utleige")
	private EntityManager em;

	public Firma hentFirma() {
		return em.find(Firma.class, "Bilutleige AS");
	}

	
}
