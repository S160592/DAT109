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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling datalagring;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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

			response.sendRedirect("minSide");
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (InnloggingUtil.isInnlogget(request)) {

			response.sendRedirect("minSide");
		} else {

			Kunde kunde = datalagring.hentKunde(request.getParameter("telefonnr"));
			if (kunde == null) {
				response.sendRedirect("login");
			} else if (kunde.getEtternavn().equals(request.getParameter("etternavn"))) {
				InnloggingUtil.loggInnMedTimeout(request, 120);
				request.getSession().setAttribute("username", request.getParameter("telefonnr"));
				String redirectTo = "" + (String) request.getSession().getAttribute("commingFrom");
				
				switch (redirectTo) {
				case "minSide":
					System.out.println("sending to minSide");
					response.sendRedirect("minSide");
					break;
				case "reserver" :
					response.sendRedirect("reserver");
					break;
				default:
					response.sendRedirect("login");
					break;
				}
				
			} else {
				response.sendRedirect("login");
			}

		}

	}

}
