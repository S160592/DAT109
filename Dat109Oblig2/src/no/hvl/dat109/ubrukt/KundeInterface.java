package no.hvl.dat109.ubrukt;

import no.hvl.dat109.Entity.Adress;

public interface KundeInterface {
	public String getTelefonnummer();

	public void setTelefonnummer(String telefonnummer);

	public String getEtternavn();

	public void setEtternavn(String etternavn);

	public String getFornavn();

	public void setFornavn(String fornavn);

	public String getKredittkortnr();

	public void setKredittkortnr(String kredittkortnr);

	public Adress getAdress();

	public void setAdress(Adress adress);
}
