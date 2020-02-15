package Borgar.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Borgar Frøysland Grande
 *
 */

public class SnakesAndLaddersGame {

	private List<Spelar> spelarar;
	private Brett brett;
	private Spelar vinner;

	/**
	 * 
	 * @param spelarar, list of the players. Min 2, max 4.
	 */
	public SnakesAndLaddersGame() {
		this.spelarar = new ArrayList<Spelar>();
		this.brett = new Brett();
	}

	/**
	 * @param spelar, add a player to the game. The Spelar will get the Brett-object
	 */
	public boolean addPlayer(Spelar spelar) {
		if (spelarar.size() > 4) {
			return false;
		} else {
			spelarar.add(spelar);
			spelar.setBrett(this.brett);
			return true;
		}
	}

	/**
	 * Start the game. This will run a simulation of the game.
	 */
	public void start() {
		if (spelarar.size() > 1 && spelarar.size() < 5) {

			Spelar nextPlayer = spelarar.get(0);
			int teller = 0;
			while (vinner == null) {
				spelarar.forEach(
						x -> System.out.println(x.getNavn() + " står på plass: " + x.getPlassering().getRuteNr()));
				System.out.println();
				System.out.println();
				System.out.println("Neste spelar er : " + nextPlayer.getNavn());
				nextPlayer.spillTur();

				if (nextPlayer.isVinner()) {
					vinner = nextPlayer;
					System.out.println();
					System.out.println();
					System.err.println("Winner is : " + nextPlayer.getNavn());
					break;
				}
				teller++;
				System.out.println();
				System.out.println();
				nextPlayer = spelarar.get(teller % 3);

			}
		} else {
			System.out.println("Manglar spelarar");
		}

	}
	
	
}