package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Interfaces.Databehandling;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class FinnReservasjon
 */
@WebServlet("/AdminFinnReservasjon")
public class FinnReservasjon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Databehandling databehandling;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinnReservasjon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(InnloggingUtil.isInnloggetSomAdmin(request)) {
			String reservasjonsID = request.getParameter("reservasjonsID");
			if(reservasjonsID == "" || reservasjonsID == null) {
				
			}else {
				request.setAttribute("reservasjon", databehandling.getReservasjon(reservasjonsID));
			}
			request.getRequestDispatcher("WEB-INF/jsp/finnReservasjon.jsp").forward(request, response);
		}else {
			response.sendRedirect("sok");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
