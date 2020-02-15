package Jonas;

import Jonas.Brett;

/**
 * Klasse som definerer ein brikke.
 * 
 * @author jonas
 */
public class Brikke {

	private Rute rute;
	private int brikkeNr;

	/**
	 * Oppretter ein ny brikke.
	 * 
	 * @param navn
	 * @param start
	 */
	public Brikke(int brikkeNr, Rute start) {
		super();
		this.rute = start;
		this.brikkeNr = brikkeNr;
	}

	public int getBrikkeNr() {
		return brikkeNr;
	}

	/**
	 * Metode som tar inn verdi frå terningkastet og plasserer brikken på den nye
	 * ruten.
	 * 
	 * @param sum
	 */
	public void flytt(int verdi) {
		setRute(Brett.finnRute(rute, verdi));
	}

	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute ruten) {
		this.rute = ruten;
	}

}
