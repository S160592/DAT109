package no.hvl.dat109.Servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Entity.Utleigekontor;
import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class Reserver
 */
@WebServlet("/reserver")
public class Reserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling databehandling;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reserver() {
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
		if (request.getSession().getAttribute("bilar") != null) {
			request.getRequestDispatcher("WEB-INF/jsp/reserver.jsp").forward(request, response);
		} else {
			response.sendRedirect("sok");
		}
		
//		request.getSession().setAttribute("bilar", null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Utleigekontor fraLokasjon = databehandling.hentUtleigekontor((int) request.getSession().getAttribute("fraLokasjon"));
		Utleigekontor tilLokasjon = databehandling.hentUtleigekontor((int) request.getSession().getAttribute("tilLokasjon"));
		Timestamp fraTimestamp = (Timestamp) request.getSession().getAttribute("fraTimestamp");
		Timestamp tilTimestamp = (Timestamp) request.getSession().getAttribute("tilTimestamp");
		
		if(InnloggingUtil.isInnlogget(request)) {
			if(fraLokasjon == null || tilLokasjon == null || fraTimestamp == null || tilTimestamp == null ) {

				response.sendRedirect("sok");
				
			}else {
				Bil bil = databehandling.hentBil(request.getParameter("bil"));
				Reservasjon reservasjon = new Reservasjon();
				reservasjon.setBilBean(bil);
				reservasjon.setFradato(fraTimestamp);
				reservasjon.setTildato(tilTimestamp);
				reservasjon.setFraUtleigekontor(fraLokasjon);
				reservasjon.setTilUtleigekotor(tilLokasjon);
				reservasjon.setKundeBean(databehandling.hentKunde((String) request.getSession().getAttribute("username")));
				databehandling.lagreReservasjon(reservasjon);
				request.getSession().setAttribute("reservasjon",reservasjon.getReservasjonsid());
				response.sendRedirect("reservasjonBekreftelse");
			}
		}
		else {
			request.getSession().setAttribute("commingFrom", "reserver");
			response.sendRedirect("login");
		}
		
		
	
		
	}

}
