package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.KundeEntity;
import no.hvl.dat109.Entity.ReservasjonEntity;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Interfaces.PersistentKunde;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;



@WebServlet({"/index.html" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PersistentBil bilEAO;
	@EJB
	private PersistentUtleigekontor utleigekontorEAO;
	@EJB
	private PersistentBiltype biltypeEAO;
	@EJB
	private PersistentAdresse adresseEAO;
	@EJB
	private PersistentKunde kundeEAO;
	@EJB
	private PersistentReservasjon reservasjonEAO;

	


	public Index() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	KundeEntity kunde = new KundeEntity();
	kunde.setAdress(adresseEAO.hentAdresse(1));
	kunde.setFornavn("Borgar");
	kunde.setEtternavn("Grande");
	kunde.setTelefonnummer(request.getParameter("mobilnr"));
	kundeEAO.leggTil(kunde);
	
	System.out.println(bilEAO.hentBil("KH51737"));
	ReservasjonEntity reservasjon = new ReservasjonEntity();
	reservasjon.setBilBean(bilEAO.hentBil("KH51737"));
	
	reservasjon.setKmstandut(2435);
	reservasjon.setKundeBean(kunde);
	reservasjon.setUtleigekontor1(utleigekontorEAO.hentUtleigekontor(1));
	reservasjon.setUtleigekontor2(utleigekontorEAO.hentUtleigekontor(2));
	
	System.out.println(reservasjonEAO.createReservasjon(reservasjon));
	//localhost:8080/DAT109Oblig2/?regnr=N8V62538&pickup=1&return=2


	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

}
