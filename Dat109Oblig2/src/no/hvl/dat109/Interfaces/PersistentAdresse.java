package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.AdressEntity;

public interface PersistentAdresse {


	public AdressEntity hentAdresse(int id);
	
	public List<AdressEntity> hentAlle();
	
}
