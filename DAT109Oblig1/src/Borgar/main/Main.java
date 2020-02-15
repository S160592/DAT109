package Borgar.main;

import java.util.ArrayList;

import Borgar.Classes.Brikke;
import Borgar.Classes.SnakesAndLaddersGame;
import Borgar.Classes.Spelar;

public class Main {

	public static void main(String[] args) {

		// This will simulate 10 games. No interaction is needed.
		for (int i = 0; i < 10; i++) {
			// Create players
			Spelar borgar = new Spelar("Borgar");
			Spelar jonas = new Spelar("Jonas");
			Spelar didrik = new Spelar("Didrik");

			// create a game
			SnakesAndLaddersGame game = new SnakesAndLaddersGame();

			// Add the players
			game.addPlayer(borgar);
			game.addPlayer(jonas);
			game.addPlayer(didrik);

			// start the game
			game.start();

			// wait for next game.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
