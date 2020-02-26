package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.BilDB;
import no.hvl.dat109.Entity.BiltypeDB;
import no.hvl.dat109.Interfaces.Bil;
import no.hvl.dat109.Interfaces.Datalagring;
import no.hvl.dat109.Superclasses.BilSuper;

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
	private Datalagring datalagring;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("WEB-INF/jsp/nyBil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Vask input

		String regnr = request.getParameter("regnr");
		String farge = request.getParameter("farge");
		String Merke = request.getParameter("Merke");
		String staarVed = request.getParameter("staarVed");
		String biltype = request.getParameter("biltype");

		Bil nyBil = new BilDB();
		BiltypeDB type = new BiltypeDB();
		type.setTypeid(biltype);
		nyBil.setBiltype(type);
		nyBil.setRegnr(regnr);
		nyBil.setMerke(Merke);
		nyBil.setStaarVedUtleigekontor(datalagring.hentUtleigekontor(Integer.valueOf(staarVed)));
		nyBil.setFarge(farge);

		datalagring.lagreBil(nyBil);

		response.sendRedirect("adminNyBil");
		
		
		BilSuper bsuper = new BilDB();
		bsuper.setBiltype(type);
		bsuper.setRegnr(regnr.replace('A', 'B'));
		bsuper.setMerke(Merke);
		bsuper.setStaarVedUtleigekontor(datalagring.hentUtleigekontor(Integer.valueOf(staarVed)));
		bsuper.setFarge(farge);
		datalagring.lagreBil(bsuper);
		
	}

}
