package Jonas;

/**
 * Klasse som definerer ei rute.
 * 
 * @author jonas
 */
public class Rute {

	private int ruteNr;

	/**
	 * Konstruktør som oppretter ei rute.
	 * 
	 * @param ruteNr
	 */
	public Rute(int ruteNr) {
		this.ruteNr = ruteNr;
	}

	public void setRuteNr(int ruteNr) {
		this.ruteNr = ruteNr;
	}

	public int getRuteNr() {
		return this.ruteNr;
	}
}
