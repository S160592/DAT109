package Borgar.Classes;

/**
 * 
 * @author Borgar Frøysland Grande
 *
 */

public class Rute {
	
	protected int ruteNr;
	protected Rute jumpTo;
	
	public Rute(int ruteNr) {
		this.ruteNr = ruteNr;
		this.jumpTo = this;
	}
	
	/**
	 * 
	 * @return int, rutenr
	 */
	public int getRuteNr() {
		return this.ruteNr;
	}
	
	/**
	 * 
	 * @return Rute, where to jump to. normal Rute points to itself. Snake points to a lower Rutenr, ladder to a higher.
	 */
	public Rute jumpTo() {
		return this.jumpTo;
	}
	
	/**
	 * 
	 * @param rute
	 * Where the jump is going. needs to be a higher rutenr for ladders, and lower for snake.
	 */
//	public void setJumpTo(Rute rute) {
//		this.jumpTo = rute;
//	}
//	
}
