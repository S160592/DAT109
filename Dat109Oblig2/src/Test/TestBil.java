package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Test.Moc.MocDatalagring;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.ubrukt.BilInterface;

class TestBil {

	Databehandling lagring = new MocDatalagring();
	
	@Test
	void testLagringAvBil() {
		Bil bil = new Bil();
		bil.setRegnr("AB12345");
		lagring.lagreBil(bil);
		assertEquals(bil, lagring.hentBil("AB12345"));;
	}

}
