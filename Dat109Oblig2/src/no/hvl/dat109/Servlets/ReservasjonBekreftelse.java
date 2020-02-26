package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Reservasjon;
import no.hvl.dat109.Interfaces.Datalagring;

/**
 * Servlet implementation class ReservasjonBekreftelse
 */
@WebServlet("/reservasjonBekreftelse")
public class ReservasjonBekreftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Datalagring datalagring;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservasjonBekreftelse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub3
		
		
		
		
		
		Reservasjon reservasjon = datalagring.getReservasjon(request.getParameter("reservasjonsnr"));
		request.setAttribute("reservasjon", reservasjon);
		request.getRequestDispatcher("WEB-INF/jsp/reservasjonsBekreftelse.jsp").forward(request, response);
	}

	
}
