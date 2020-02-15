package Jonas;

/**
 * Spesialisering av Rute. Flytter brikke.
 * 
 * @author jonas
 *
 */
public class Slange extends Rute {

	private int ruteNr;

	public Slange(int ruteNr, int nyRuteNr) {
		super(ruteNr);
		super.setRuteNr(nyRuteNr);
	}

}
