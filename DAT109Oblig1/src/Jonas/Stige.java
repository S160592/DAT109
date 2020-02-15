package Jonas;

/**
 * Spesialisering av Rute. Flytter brikke.
 * 
 * @author jonas
 *
 */
public class Stige extends Rute {
	private int ruteNr;

	public Stige(int ruteNr, int nyRuteNr) {
		super(ruteNr);
		super.setRuteNr(nyRuteNr);
	}

}
