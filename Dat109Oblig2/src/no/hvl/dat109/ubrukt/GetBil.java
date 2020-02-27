package no.hvl.dat109.ubrukt;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    private PersistentBil bilEAO;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder()
		        .excludeFieldsWithoutExposeAnnotation()
		        .create();
		System.out.println(bilEAO.hentBil("UC31787"));
		response.getWriter().append(gson.toJson(bilEAO.hentBil("UC31787")));
	}


}
