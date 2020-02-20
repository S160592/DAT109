package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Adress;

public interface PersistentAdresse {


	public Adress hentAdresse(int id);
	
	public List<Adress> hentAlle();
	public int lagre(AdressInterface adress);
}
