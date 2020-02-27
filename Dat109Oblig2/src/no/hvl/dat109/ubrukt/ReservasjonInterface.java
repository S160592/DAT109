package no.hvl.dat109.ubrukt;

import java.sql.Timestamp;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Utleigekontor;

public interface ReservasjonInterface {
	public Integer getReservasjonsid();

	public Timestamp getFradato();

	public void setFradato(Timestamp fradato);

	public Integer getKmstandinn();

	public void setKmstandinn(Integer kmstandinn);

	public Integer getKmstandut() ;

	public void setKmstandut(Integer kmstandut);

	public Timestamp getTildato();

	public void setTildato(Timestamp tildato);

	public Bil getBilBean();

	public void setBilBean(Bil bilBean);

	public Kunde getKundeBean();

	public void setKundeBean(Kunde kundeBean);

	public Utleigekontor getFraUtleigekontor();

	public void setFraUtleigekontor(Utleigekontor fraUtleigekotor);

	public Utleigekontor getTilUtleigekotor();

	public void setTilUtleigekotor(Utleigekontor tilUtleigekotor);
}
