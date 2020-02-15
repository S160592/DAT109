package Jonas;

import java.util.Random;

/**
 * Klasse som definerer ein terning.
 * 
 * @author jonas
 */
public class Terning {

	public Terning() {

	}

	/**
	 * Lager en tilfeldig int mellom 1 og 6 og returnerer denne.
	 * 
	 */
	public static int trill() {

		Random ran = new Random();
		return ran.nextInt(6) + 1;
	}
}
