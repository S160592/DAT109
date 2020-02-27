package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Interfaces.Databehandling;

/**
 * Servlet implementation class NyKunde
 */
@WebServlet("/nyKunde")
public class NyKunde extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NyKunde() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	private Databehandling datalagring;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/nyKunde.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String telefonnr = request.getParameter("telefonnr");
		String gateadresse = request.getParameter("gateadresse");
		String postnummer = request.getParameter("postnummer");
		String poststed = request.getParameter("poststed");

		Kunde kunde = new Kunde();
		Adress adresse = new Adress();

		adresse.setGateadresse(gateadresse);
		adresse.setPostnummer(postnummer);
		adresse.setPoststed(poststed);
		datalagring.lagreAdresse(adresse);

		kunde.setAdress(adresse);
		kunde.setFornavn(fornavn);
		kunde.setEtternavn(etternavn);
		kunde.setTelefonnummer(telefonnr);
		datalagring.lagreNyKunde(kunde);

		response.sendRedirect("nyKunde");
	}

}
