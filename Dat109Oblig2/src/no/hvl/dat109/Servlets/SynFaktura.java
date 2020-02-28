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

/**
 * Servlet implementation class Faktura
 */
@WebServlet("/faktura")
public class SynFaktura extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling databehandling;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SynFaktura() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Reservasjon reservasjon = databehandling.getReservasjon(request.getParameter("reservasjonsid"));
		
		if (InnloggingUtil.isInnlogget(request)) {
			
		} else {
			response.sendRedirect("sok");
		}
	}

}
