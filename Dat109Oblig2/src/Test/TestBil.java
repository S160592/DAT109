package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Test.Moc.MocDatalagring;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Interfaces.BilInterface;

class TestBil {

	MocDatalagring lagring = new MocDatalagring();
	
	@Test
	void testLagringAvBil() {
		BilInterface bil = new Bil();
		bil.setRegnr("AB12345");
		lagring.lagreBil(bil);
		assertEquals(bil, lagring.hentBil("AB12345"));;
	}

}
