package no.hvl.dat109.RESTAPI;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import no.hvl.dat109.Interfaces.PersistentBil;

/**
 * Servlet implementation class GetBil
 */
@WebServlet("/GetBil")
public class GetBil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBil() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    PersistentBil PersBil;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		response.getWriter().append(gson.toJson(PersBil.hentBil(request.getParameter("regnr"))));
	}


}