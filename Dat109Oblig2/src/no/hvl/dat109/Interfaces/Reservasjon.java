package no.hvl.dat109.Interfaces;

import java.sql.Timestamp;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.KundeDB;
import no.hvl.dat109.Entity.UtleigekontorDB;

public interface Reservasjon {
	public Integer getReservasjonsid();

	public Timestamp getFradato();

	public void setFradato(Timestamp fradato);

	public Integer getKmstandinn();

	public void setKmstandinn(Integer kmstandinn);

	public Integer getKmstandut() ;

	public void setKmstandut(Integer kmstandut);

	public Timestamp getTildato();

	public void setTildato(Timestamp tildato);

	public BilDB getBilBean();

	public void setBilBean(BilDB bilBean);

	public KundeDB getKundeBean();

	public void setKundeBean(KundeDB kundeBean);

	public UtleigekontorDB getFraUtleigekontor();

	public void setFraUtleigekontor(UtleigekontorDB fraUtleigekotor);

	public UtleigekontorDB getTilUtleigekotor();

	public void setTilUtleigekotor(UtleigekontorDB tilUtleigekotor);
}
