package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Test.Moc.MocDatalagring;
import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Interfaces.Bil;

class TestBil {

	MocDatalagring lagring = new MocDatalagring();
	
	@Test
	void testLagringAvBil() {
		Bil bil = new BilDB();
		bil.setRegnr("AB12345");
		lagring.lagreBil(bil);
		assertEquals(bil, lagring.hentBil("AB12345"));;
	}

}
