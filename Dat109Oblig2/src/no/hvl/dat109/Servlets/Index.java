package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Interfaces.PersistentAdresse;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentBiltype;
import no.hvl.dat109.Interfaces.PersistentKunde;
import no.hvl.dat109.Interfaces.PersistentReservasjon;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@WebServlet({ "/index.html" })
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

		Kunde kunde = new Kunde();
		kunde.setEtternavn(request.getParameter("etternavn"));
		kunde.setFornavn(request.getParameter("fornavn"));
		kunde.setTelefonnummer(request.getParameter("telefonnr"));
		kunde.setAdress(adresseEAO.hentAdresse(1));
		kundeEAO.leggTil(kunde);

		// localhost:8080/DAT109Oblig2/?etternavn=grande&fornavn=bogar&telefonnr=12345678

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
