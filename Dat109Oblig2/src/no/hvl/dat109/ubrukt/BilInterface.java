package no.hvl.dat109.ubrukt;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Utleigekontor;

public interface BilInterface {

	public String getRegnr();
	public void setRegnr(String regnr);
	public String getFarge();
	public void setFarge(String farge);
	public String getMerke();
	public void setMerke(String merke);
	public void setBiltype(Bil biltype) ;
	public void setStaarVedUtleigekontor(Utleigekontor utleigekontor);
	public Utleigekontor getStaarVedUtleigekontor();
	public BiltypeInterface getBiltype();
	
	
}
