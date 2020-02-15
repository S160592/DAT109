package Borgar.Classes;

public class Spelar {

	private String navn;
	private Brikke brikke;
	private Brett brett;
	private Boolean vinner;
	private Terning terning;
	private Boolean backOnStart;

	/**
	 * Constructors
	 * 
	 * @param navn is the players name.
	 */
	public Spelar(String navn) {
		this.navn = navn;
		this.vinner = false;
		this.terning = new Terning();
		this.backOnStart = false;

	}

	/**
	 * 
	 * @param brett, add the brett so the player know where to play.
	 */
	public void setBrett(Brett brett) {
		this.brett = brett;
		this.brikke = new Brikke(brett.getStartRute());
	}

	/**
	 * 
	 * @return the players name
	 */
	public String getNavn() {
		return this.navn;
	}

	/**
	 * 
	 * @return the current Rute the player is located on.
	 */
	public Rute getPlassering() {
		return this.brikke.getPlass();
	}

	/**
	 * Makes the player play its turn.
	 */
	public void spillTur() {

		// Toss the dice
		terning.trill();

		// perform the move
		move();

		// if the value from tossing the dice is 6 three times, move the brikke to start.
		for (int i = 0; i < 3 && terning.getVerdi() == 6; i++) {
			if (i == 2) {

				System.err.println(this.navn + " kasta 6 tre gongar, flytt tilbake til start");
				brikke.setPlass(brett.getStartRute());
				// needs to know if it's the first time 
				backOnStart = true;			
			} else {
				System.out.println(this.navn + " kasta 6 " + (i + 1) + " gongar og får trille ein gong til.");
				terning.trill();
				move();
			}

		}

	}

	/**
	 * Perform the move based on the toss.
	 */
	private void move() {
		// NOTE
		// Det er lagt til nokon sleep innimellom for å minske hastigheiten på spelet,
		// samt gi maskina tid til å skrive ut.
		System.out.println(this.navn + " triller : " + terning.getVerdi());

		// if it's back on start after getting 6 three times, it needs 6 to continue.
		if (backOnStart && terning.getVerdi() != 6) {
			System.out.println("back on start");
		}
		// otherwise
		else {
			backOnStart = false;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(this.navn + " stod på plass " + brikke.getPlass().getRuteNr());

			// update the current location to the new location. The Brett will decide.
			brikke.setPlass(brett.nyPlassering(this.brikke.getPlass(), terning.getVerdi()));

			System.out.println(this.navn + " flytta til plass " + brikke.getPlass().getRuteNr());

			// if the Rute can jump to another place than itself, then jump.
			if (brikke.getPlass().jumpTo().equals(brikke.getPlass())) {

			} else {
				brikke.setPlass(brikke.getPlass().jumpTo());
				System.out.println("jumps to : " + brikke.getPlass().getRuteNr());
			}

			// check if the player is on the last Rute. if, then the player is the winner.
			if (brikke.getPlass().getRuteNr() == 99) {
				this.vinner = true;
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Check if the player has won the game by standing on the last Rute.
	 * 
	 * @return true / false
	 */
	public Boolean isVinner() {
		return this.vinner;
	}

}
