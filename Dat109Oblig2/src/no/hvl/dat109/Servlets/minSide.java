package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Kunde;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class minSide
 */
@WebServlet("/minSide")
public class minSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling databehandling;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public minSide() {
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
		if (InnloggingUtil.isInnlogget(request)) {
			Kunde kunde = databehandling.hentKunde((String) request.getSession().getAttribute("username"));
			request.setAttribute("reservasjonar", databehandling.hentReservasjonarFor(kunde));
			request.getRequestDispatcher("WEB-INF/jsp/minSide.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("commingFrom", "minSide");
			response.sendRedirect("login");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
