package Borgar.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Borgar.Classes.SnakesAndLaddersGame;
import Borgar.Classes.Spelar;

class TestCreateGame {

	@Test
	void test() {
		SnakesAndLaddersGame game = new SnakesAndLaddersGame();
		
		
		
		Spelar spelar1 = new Spelar("Spelar1");
		Spelar spelar2 = new Spelar("Spelar2");
		Spelar spelar3 = new Spelar("Spelar3");
		Spelar spelar4 = new Spelar("Spelar4");
		Spelar spelar5 = new Spelar("Spelar5");
		assertTrue(game.addPlayer(spelar1));
		assertTrue(game.addPlayer(spelar2));
		assertTrue(game.addPlayer(spelar3));
		assertTrue(game.addPlayer(spelar4));
		assertTrue(game.addPlayer(spelar5));
		
	}

}
