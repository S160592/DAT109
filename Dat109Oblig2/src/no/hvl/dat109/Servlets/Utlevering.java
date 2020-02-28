package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class Utlevering
 */
@WebServlet("/adminUtlevering")
public class Utlevering extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling databehandling;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Utlevering() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reservasjonsid = request.getParameter("reservasjonsid");
		if (InnloggingUtil.isInnloggetSomAdmin(request) && reservasjonsid != null) {
			request.setAttribute("reservasjon", databehandling.getReservasjon(reservasjonsid));
			request.getRequestDispatcher("WEB-INF/jsp/utlevering.jsp").forward(request, response);
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
			Reservasjon reservasjon = databehandling.getReservasjon(request.getParameter("reservasjonsid"));
			reservasjon.setKmstandinn(Integer.valueOf(request.getParameter("kmstand")));
			String kredittkort = request.getParameter("kredittkort");
			if (kredittkort != null) {
				Kunde kunde = reservasjon.getKundeBean();
				kunde.setKredittkortnr(kredittkort);
				databehandling.oppdaterKunde(kunde);
			}
			response.sendRedirect("Admin");
		} else {
			response.sendRedirect("sok");
		}

	}

}
