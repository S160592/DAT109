package no.hvl.dat109.Interfaces;

import java.util.List;

import no.hvl.dat109.Entity.Faktura;

public interface PersistentFaktura {


	public List<Faktura> hentAlleFaktura();

	public int nyFaktura(Faktura faktura);

	public Faktura getFaktura(int fakturanr);
}
