package no.hvl.dat109.Interfaces;

import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Superclasses.BiltypeSuper;

public interface BilInterface {

	public String getRegnr();
	public void setRegnr(String regnr);
	public String getFarge();
	public void setFarge(String farge);
	public String getMerke();
	public void setMerke(String merke);
	public void setBiltype(BiltypeSuper biltype) ;
	public void setStaarVedUtleigekontor(Utleigekontor utleigekontor);
	public Utleigekontor getStaarVedUtleigekontor();
	public BiltypeInterface getBiltype();
	
	
}
