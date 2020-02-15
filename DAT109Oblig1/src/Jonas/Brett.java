package Jonas;

/**
 * Klasse som definerer eit brett.
 * 
 * @author jonas
 */
public class Brett {
	static Rute[] ruter;

	/**
	 * Oppretter eit nytt brett med nummer på ruter.
	 * 
	 * Inkluderer også slanger(flytter brikken tilbake) og, stiger(flytter brikken
	 * fram).
	 */
	public Brett() {
		ruter = new Rute[100];
		for (int i = 0; i < 100; i++) {
			ruter[i] = new Rute(i);
		}
		ruter[4] = new Stige(4, 14);
		ruter[2] = new Stige(2, 38);
		ruter[8] = new Stige(8, 31);
		ruter[28] = new Stige(28, 84);
		ruter[21] = new Stige(21, 42);
		ruter[36] = new Stige(36, 44);
		ruter[51] = new Stige(51, 67);
		ruter[71] = new Stige(71, 91);

		ruter[16] = new Slange(16, 6);
		ruter[47] = new Slange(47, 26);
		ruter[49] = new Slange(49, 11);
		ruter[62] = new Slange(62, 18);
		ruter[56] = new Slange(56, 53);
		ruter[64] = new Slange(64, 60);

	}

	public Rute[] getRuter() {
		return ruter;
	}

	public static Rute start() {
		return Brett.ruter[0];
	}

	/**
	 * Metode som finner og returnerer en plass.
	 * 
	 * @param plass
	 * @param antall
	 * @return
	 */
	public static Rute finnRute(Rute plass, int antall) {

		if ((plass.getRuteNr() + antall) > 99) {
			return plass;
		} else {
			Rute nyplass = ruter[plass.getRuteNr() + antall];
			return nyplass;
		}

	}

}
