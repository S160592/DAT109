package no.hvl.dat109.hjelpeklasser;

import no.hvl.dat109.Entity.Reservasjon;

public class Priskalkulator {

	public static int reservasjonspris(Reservasjon reservasjon) {
		int dagspris = reservasjon.getBilBean().getBiltype().getDagspris();
		int antallDagar = (int) (((reservasjon.getTildato().getTime() - reservasjon.getFradato().getTime())/8640000)/10);
		System.out.println("Dagspris : " + dagspris);
		System.out.println("Antall dagar : " + antallDagar);
		return antallDagar * dagspris + dagspris;
	}
	
}
