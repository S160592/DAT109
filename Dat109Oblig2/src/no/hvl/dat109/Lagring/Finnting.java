package no.hvl.dat109.Lagring;

//@Stateless
public class Finnting {
//
//	@PersistenceContext(name = "utleige")
//	private EntityManager em;
////
//	public Finnting() {
//
//	}
//	
//	
//	 
//
//	public List<Bil> finnledigeBilar(Timestamp fra, Timestamp til, Utleigekontor fraLokasjon) {
//
//		List<Reservasjon> reservasjonar = em.createNamedQuery("Reservasjon.findAll", Reservasjon.class).getResultList();
//		List<Bil> bilar = em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
//		List<String> reserverte = new ArrayList<String>();
//
//		reservasjonar.forEach(r -> {
//
//			if (r.getFradato().before(fra) && r.getTildato().after(til)) {
//				reserverte.add(r.getBilBean().getRegnr());
//			}
//
//		});
//
//		List<Bil> ledigeBilar = bilar.stream()
//				.filter(b -> !reserverte.contains(b.getRegnr()) && b.getUtleigekontor().getId() == fraLokasjon.getId())
//				.collect(Collectors.toList());
//		
//		return ledigeBilar;
//	}

}
