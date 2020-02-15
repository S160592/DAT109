package Borgar.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Borgar.Classes.Terning;;
class TestTerning {

	/**
	 * Run testRandom 100 times to check that the value is between 1 and 6
	 */
	@Test
	void testRandom() {
		Terning terning = new Terning();
		for (int i = 0; i < 100; i++) {
			// Toss the dice
			terning.trill();
			assertTrue(terning.getVerdi() > 0 && terning.getVerdi() < 7);
		}
		
	}

}
