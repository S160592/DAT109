package no.hvl.dat109.Servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Interfaces.PersistentKunde;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

/**
 * Servlet implementation class testus
 */
@WebServlet("/testus")
public class testus extends HttpServlet {
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

    /**
     * @see HttpServlet#HttpServlet()
     */
    public testus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(bilEAO.hentBil("UC31787"));

		String regnr = request.getParameter("regnr");
		String kundentelefon = request.getParameter("telefonnr");
		Kunde kunde = kundeEAO.finnKunde(kundentelefon);
		
		Bil bil = bilEAO.hentBil(regnr);
		
		Reservasjon reservasjon = new Reservasjon();
		
		reservasjon.setBilBean(bil);
		reservasjon.setKundeBean(kunde);
		Date date= new Date();
		 
		 long time = date.getTime();
		     System.out.println("Time in Milliseconds: " + time);
		 long from = time - 1000000000;
		 long til = time + 1000000000;
		 Timestamp fromtime  = new Timestamp(from);

		 Timestamp totime= new Timestamp(til);
		 reservasjon.setFradato(fromtime);
		 reservasjon.setTildato(totime);
		 reservasjon.setUtleigekontor1(utleigekontorEAO.hentUtleigekontor(1));
		 reservasjon.setUtleigekontor2(utleigekontorEAO.hentUtleigekontor(2));
		 reservasjon.setKmstandut(762354);
		reservasjonEAO.createReservasjon(reservasjon);
		//http://localhost:8080/DAT109Oblig2/testus?regnr=KH51979&telefonnr=81548300
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
