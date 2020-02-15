package Jonas;

import java.util.ArrayList;

import Jonas.Terning;

/**
 * Klasse som oppretter liste av spillere og starter spill.
 * 
 * @author jonas
 *
 */
public class Klient {

	public static void main(String[] args) {

		Spiller[] spillere = new Spiller[5];
		spillere[0] = new Spiller("Jon");
		spillere[1] = new Spiller("per");
		spillere[2] = new Spiller("pål");
		spillere[3] = new Spiller("ulf");
		spillere[4] = new Spiller("jan");

		SALGame nyttSpill = new SALGame();

		nyttSpill.start(spillere);
	}

}
