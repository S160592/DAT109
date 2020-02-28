package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Faktura;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;
import no.hvl.dat109.hjelpeklasser.Priskalkulator;

/**
 * Servlet implementation class Innlevering
 */
@WebServlet("/adminInnlevering")
public class Innlevering extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Databehandling databehandling;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Innlevering() {
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
		String reservasjonsid = request.getParameter("reservasjonsid");
		if (InnloggingUtil.isInnloggetSomAdmin(request) && reservasjonsid != null) {
			request.setAttribute("reservasjon", databehandling.getReservasjon(reservasjonsid));
			request.getRequestDispatcher("WEB-INF/jsp/innlevering.jsp").forward(request, response);
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
			Faktura faktura = new Faktura();
			faktura.setPris(Priskalkulator.reservasjonspris(reservasjon));
			databehandling.nyFaktura(faktura);
			reservasjon.setFaktura(faktura);
			
//			reservasjon.setFaktura(faktura);
			databehandling.oppdaterReservasjon(reservasjon);
			response.sendRedirect("faktura?reservasjonsid=" + reservasjon.getReservasjonsid());
		} else {
			response.sendRedirect("sok");
		}
	}

}
