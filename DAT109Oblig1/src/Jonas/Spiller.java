package Jonas;

/**
 * Klasse som definerer ein spiller.
 * 
 * @author jonas
 */

public class Spiller {

	private String navn;
	private Brikke brikke;

	/**
	 * Konstruktør som oppretter ein ny spiller.
	 * 
	 * @param navn
	 */
	public Spiller(String navn) {
		super();
		this.navn = navn;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * Metode som spiller trekk
	 * 
	 */
	public void spillTrekk() {
		int antall = Terning.trill();
		brikke.flytt(antall);
	}

}
