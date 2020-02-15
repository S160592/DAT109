package Borgar.Classes;
/**
 * 
 * @author Borgar Frøysland Grande
 *
 */
public class Brikke {
	
	private int brikkeNr;
	private Rute plass;
	
	/**
	 * Constructor.
	 * @param startRute, define where the Brikke should be located.
	 */
	public Brikke(Rute startRute) {
		this.plass = startRute;
	}
	
	/**
	 * Returns the current location
	 * @return Rute
	 */
	public Rute getPlass() {
		return this.plass;
	}
	
	/**
	 * Set the location for the Brikke.
	 * @param plass of type Rute
	 */
	public void setPlass(Rute plass) {
		this.plass = plass;
	}

}
