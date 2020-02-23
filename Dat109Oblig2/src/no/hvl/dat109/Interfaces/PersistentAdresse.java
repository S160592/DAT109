package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.AdressDB;

public interface PersistentAdresse {


	public AdressDB hentAdresse(int id);
	
	public List<AdressDB> hentAlle();
	public int lagre(Adress adress);
}
