package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.AdressDB;

public interface Kunde {
	public String getTelefonnummer();

	public void setTelefonnummer(String telefonnummer);

	public String getEtternavn();

	public void setEtternavn(String etternavn);

	public String getFornavn();

	public void setFornavn(String fornavn);

	public String getKredittkortnr();

	public void setKredittkortnr(String kredittkortnr);

	public AdressDB getAdress();

	public void setAdress(AdressDB adress);
}
