package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class NyBil
 */
@WebServlet("/adminNyBil")

public class NyBil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NyBil() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	private Databehandling databehandling;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (InnloggingUtil.isInnloggetSomAdmin(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/nyBil.jsp").forward(request, response);
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

		if (InnloggingUtil.isInnloggetSomAdmin(request)) {
			String regnr = request.getParameter("regnr");
			String farge = request.getParameter("farge");
			String Merke = request.getParameter("Merke");
			String staarVed = request.getParameter("staarVed");
			String biltype = request.getParameter("biltype");

			Bil nyBil = new Bil();

			nyBil.setBiltype(databehandling.hentBiltype(biltype));
			nyBil.setRegnr(regnr);
			nyBil.setMerke(Merke);
			nyBil.setStaarVedUtleigekontor(databehandling.hentUtleigekontor(Integer.valueOf(staarVed)));
			nyBil.setFarge(farge);

			databehandling.lagreBil(nyBil);

			response.sendRedirect("adminNyBil");
		} else {
			response.sendRedirect("sok");
		}

	}

}
