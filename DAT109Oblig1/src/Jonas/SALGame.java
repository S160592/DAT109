package Jonas;

import Jonas.Spiller;

/**
 * Klasse som definerer spillet.
 * 
 * @author jonas
 */
public class SALGame {
	public boolean erFerdig = false;
	Brett brett = new Brett();
	
	/**
	 * Metode som starter og holder i gang spillet til nokon har fått 99 poeng. Spillerene starter på 0.
	 * @param spillere
	 */
	public void start(Spiller[] spillere) {
		tildelBrikker(spillere);
		while (!erFerdig) {
			for (int i = 0; i < spillere.length; i++) {

				spillere[i].spillTrekk();

				if (spillere[i].getBrikke().getRute().getRuteNr() == 99) {
					erFerdig = true;
					System.out.println(spillere[i].getNavn() + " vant!");
					break;
				}
			}
		}
	}
	
	/**
	 * Metode som gir spillerene kvar sin brikke.
	 * @param spillere
	 */
	public void tildelBrikker(Spiller[] spillere) {

		for (int i = 0; i < spillere.length; i++) {
			Brikke brikke = new Brikke(i, Brett.start());
			spillere[i].setBrikke(brikke);
		}
	}
}
