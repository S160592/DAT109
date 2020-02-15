package no.hvl.dat108.Entity;


import javax.persistence.*;



@Entity
@NamedQuery(name="Bil.findAll", query="SELECT b FROM Bil b")
public class Bil {
	

	@Id
	private String regnr;
	
	public Bil() {
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	@Override
	public String toString() {
		return "Bil [regnr=" + regnr + "]";
	}
	
	



}