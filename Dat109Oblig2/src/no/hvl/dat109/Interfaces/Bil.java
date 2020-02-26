package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.BiltypeDB;
import no.hvl.dat109.Entity.UtleigekontorDB;
import no.hvl.dat109.Superclasses.BiltypeSuper;

public interface Bil {

	public String getRegnr();
	public void setRegnr(String regnr);
	public String getFarge();
	public void setFarge(String farge);
	public String getMerke();
	public void setMerke(String merke);
	public void setBiltype(BiltypeSuper biltype) ;
	public void setStaarVedUtleigekontor(UtleigekontorDB utleigekontor);
	public UtleigekontorDB getStaarVedUtleigekontor();
	public Biltype getBiltype();
	
	
}
