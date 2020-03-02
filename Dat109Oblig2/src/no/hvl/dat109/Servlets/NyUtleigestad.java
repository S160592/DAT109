package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;
import sun.jvm.hotspot.oops.DataLayout;

/**
 * Servlet implementation class NyUtleigestad
 */
@WebServlet("/adminNyUtleigestad")
public class NyUtleigestad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Databehandling databehandling;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NyUtleigestad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (InnloggingUtil.isInnloggetSomAdmin(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/nyUtleigestad.jsp").forward(request, response);
		} else {
			response.sendRedirect("sok");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (InnloggingUtil.isInnloggetSomAdmin(request)) {

			Adress adresse = new Adress();

			adresse.setGateadresse(request.getParameter("gateadresse"));
			adresse.setPostnummer(request.getParameter("postnummer"));
			adresse.setPoststed(request.getParameter("poststed"));

			Utleigekontor nyttKontor = new Utleigekontor();

			nyttKontor.setTelefonnr(request.getParameter("telefonnr"));
			nyttKontor.setFirma(databehandling.hentFirma());
			databehandling.lagreAdresse(adresse);
			nyttKontor.setAdress(adresse);
			databehandling.nyttUtleigekontor(nyttKontor);
			response.sendRedirect("adminNyUtleigestad");
		} else {
			response.sendRedirect("sok");
		}
	}

}
