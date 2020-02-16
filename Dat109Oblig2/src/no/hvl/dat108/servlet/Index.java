package no.hvl.dat108.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.EAO.AdresseEAO;
import no.hvl.dat108.EAO.BilEAO;
import no.hvl.dat108.EAO.BiltypeEAO;
import no.hvl.dat108.EAO.KundeEAO;
import no.hvl.dat108.EAO.ReservasjonEAO;
import no.hvl.dat108.EAO.UtleigekontorEAO;
import no.hvl.dat108.Entity.Bil;
import no.hvl.dat108.Entity.Kunde;
import no.hvl.dat108.Entity.Reservasjon;



@WebServlet({"/index.html" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BilEAO bilEAO;
	@EJB
	private UtleigekontorEAO utleigekontorEAO;
	@EJB
	private BiltypeEAO biltypeEAO;
	@EJB
	private AdresseEAO adresseEAO;
	@EJB
	private KundeEAO kundeEAO;
	@EJB
	private ReservasjonEAO reservasjonEAO;

	


	public Index() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//	
//	Kunde kunde = new Kunde();
//	kunde.setAdress(adresseEAO.hentAdresse(1));
//	kunde.setFornavn("Borgar");
//	kunde.setEtternavn("Grande");
//	kunde.setTelefonnummer(request.getParameter("mobilnr"));
//	kundeEAO.leggTil(kunde);
//	
//	System.out.println(bilEAO.hentBil("KH51737"));
//	Reservasjon reservasjon = new Reservasjon();
//	reservasjon.setBilBean(bilEAO.hentBil("KH51737"));
//	
//	reservasjon.setKmstandut(2435);
//	reservasjon.setKundeBean(kunde);
//	reservasjon.setUtleigekontor1(utleigekontorEAO.hentUtleigekontor(1));
//	reservasjon.setUtleigekontor2(utleigekontorEAO.hentUtleigekontor(2));
//	
//	System.out.println(reservasjonEAO.createReservasjon(reservasjon));
	//localhost:8080/DAT109Oblig2/?regnr=N8V62538&pickup=1&return=2


	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

}
