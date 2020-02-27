package no.hvl.dat109.ubrukt;

import no.hvl.dat109.Entity.Adress;

public interface UtleigekontorInterface {
//	public UtleigekontorDB hentUtleigekontor(int id);
//	public List<UtleigekontorDB> hentAlle();

	public Integer getId();

	public void setId(Integer id);

	public String getTelefonnr() ;

	public void setTelefonnr(String telefonnr);

	public Adress getAdress() ;

	public void setAdress(Adress adress);
}
