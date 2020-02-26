package no.hvl.dat109.Superclasses;

import java.sql.Timestamp;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.KundeDB;
import no.hvl.dat109.Entity.UtleigekontorDB;
import no.hvl.dat109.Interfaces.Reservasjon;

public class ReservasjonSuper implements Reservasjon {

	@Override
	public Integer getReservasjonsid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getFradato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFradato(Timestamp fradato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getKmstandinn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKmstandinn(Integer kmstandinn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getKmstandut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKmstandut(Integer kmstandut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Timestamp getTildato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTildato(Timestamp tildato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BilDB getBilBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBilBean(BilDB bilBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KundeDB getKundeBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKundeBean(KundeDB kundeBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtleigekontorDB getFraUtleigekontor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFraUtleigekontor(UtleigekontorDB fraUtleigekotor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtleigekontorDB getTilUtleigekotor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTilUtleigekotor(UtleigekontorDB tilUtleigekotor) {
		// TODO Auto-generated method stub
		
	}

}
