package no.hvl.dat109.Servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Interfaces.Datalagring;

/**
 * Servlet implementation class SokOgReserver
 */
@WebServlet("/sok")
public class Sok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sok() {
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
		java.util.Date dato = new java.util.Date();
		Timestamp TimeStmpDato = new Timestamp(dato.getTime());
		request.setAttribute("dato", TimeStmpDato);

		request.getRequestDispatcher("WEB-INF/jsp/sok.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date fra = Date.valueOf(request.getParameter("trip-start"));
		Date til = Date.valueOf(request.getParameter("trip-end"));
		int fraLokasjon = Integer.valueOf(request.getParameter("fraLokasjon"));

		int tilLokasjon = Integer.valueOf(request.getParameter("tilLokasjon"));
		
		String biltype = request.getParameter("biltype");
		
		Timestamp fraTimestamp = new Timestamp(fra.getTime());
		Timestamp tilTimestamp = new Timestamp(til.getTime());

		request.getSession().setAttribute("fraTimestamp", fraTimestamp);
		request.getSession().setAttribute("tilTimestamp", tilTimestamp);
		request.getSession().setAttribute("fraLokasjon", fraLokasjon);
		request.getSession().setAttribute("tilLokasjon", tilLokasjon);
		
		request.getSession()
				.setAttribute("bilar", datalagring
						.finnledigeBilar(fraTimestamp, tilTimestamp, datalagring.hentUtleigekontor(fraLokasjon))
						.stream().filter(b -> b.getBiltype().getTypeid().equals(biltype)).collect(Collectors.toList()));

		response.sendRedirect("reserver");

	}

}
