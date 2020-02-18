package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Biltype;
import no.hvl.dat109.Entity.Utleigekontor;

public interface Bil {

	public String getRegnr();

	public void setRegnr(String regnr);

	public String getFarge();

	public void setFarge(String farge);

	public String getMerke();

	public void setMerke(String merke);
	public void setBiltype(Biltype biltype) ;
	public void setUtleigekontor(Utleigekontor utleigekontor);
	
}
