package no.hvl.dat109.Servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Entity.Adress;
import no.hvl.dat109.Interfaces.Datalagring;

/**
 * Servlet implementation class NyAdresse
 */
@WebServlet("/NyAdresse")
public class NyAdresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NyAdresse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @EJB
	private Datalagring datalagring;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/newAdress.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gatenr = request.getParameter("gatenr");
		String poststed = request.getParameter("poststed");
		String postkode = request.getParameter("postkode");


		Adress newAdr = new Adress();
		newAdr.setGateadresse(gatenr);
		newAdr.setPostnummer(postkode);
		newAdr.setPoststed(poststed);
		datalagring.lagreAdresse(newAdr); 
		

		response.sendRedirect("NyAdresse");
	}
	

}
