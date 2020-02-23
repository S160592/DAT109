package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.AdressDB;

public interface Utleigekontor {
//	public UtleigekontorDB hentUtleigekontor(int id);
//	public List<UtleigekontorDB> hentAlle();

	public Integer getId();

	public void setId(Integer id);

	public String getTelefonnr() ;

	public void setTelefonnr(String telefonnr);

	public AdressDB getAdress() ;

	public void setAdress(AdressDB adress);
}
