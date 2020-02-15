package Borgar.Classes;

import java.util.Random;

/**
 * @author Borgar Frøysland Grande
 */
public class Terning {

	private int verdi;

	/**
	 * Constructor for Terning
	 */
	public Terning() {
		verdi = 0;
	}

	/**
	 * Toss the dice Generates a number from 1-6, can be collected using getVerdi()
	 */
	public void trill() {
			Random random = new Random();
			verdi = random.nextInt((6 - 1) + 1) + 1;		
	}

	/**
	 * Returns value of verdi.
	 * 
	 * @return int-value 1-6
	 */
	public int getVerdi() {
		return this.verdi;
	}

}
