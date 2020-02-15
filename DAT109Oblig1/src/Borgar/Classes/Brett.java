package Borgar.Classes;

import java.util.ArrayList;
import java.util.List;

public class Brett {

	private Rute[] ruter = new Rute[100];

	/**
	 * Constructor. Will also create the Rute.
	 */
	public Brett() {
		createRoutes();

	}

	/**
	 * Creates the Rute. 
	 */
	private void createRoutes() {
		for (int i = 0; i < 100; i++) {
			ruter[i] = new Rute(i);
		}
		ruter[2] = new Ladder(2, ruter[7]);
		//ruter[2].setJumpTo(ruter[7]);
		
		ruter[22] = new Snake(22, ruter[5]);
		//ruter[22].setJumpTo(ruter[5]);
		
		ruter[11] = new Ladder(11, ruter[78]);
		//ruter[11].setJumpTo(ruter[78]);
		
		ruter[79] = new Snake(79, ruter[57]);
//		ruter[79].setJumpTo(ruter[57]);
		
		ruter[80] = new Snake(80, ruter[48]);
//		ruter[80].setJumpTo(ruter[48]);
		

	}

	/**
	 * 
	 * @return the first Rute in the game.
	 */
	public Rute getStartRute() {
		return this.ruter[0];
	}

	/**
	 * Calculates the next location based on the antallRute.
	 * @param rute, is the corrent location of the player.
	 * @param antallRute the value of the dice.
	 * @return a pointer to the new Rute. please is the jumpTo()-method on the Rute to jump to next location.
	 */
	public Rute nyPlassering(Rute rute, int antallRute) {
		if (rute.getRuteNr() + antallRute > 99) {
			return rute;
		} else {
			return ruter[rute.getRuteNr() + antallRute];
		}
	}

	
	
}
