package no.hvl.dat109.Servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Interfaces.Datalagring;

@WebServlet({ "/index.html" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@EJB
//	private PersistentBil bilEAO;
//	@EJB
//	private PersistentUtleigekontor utleigekontorEAO;
	@EJB
	private Datalagring datalagring;

	public Index() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Bil bil = bilEAO.hentBil(request.getParameter("regnr"));
//		int utleigekontor = Integer.valueOf(request.getParameter("kontor"));
//		bil.setUtleigekontor(utleigekontorEAO.hentUtleigekontor(utleigekontor));
//		bilEAO.update(bil);
//
		Date date = new Date();

		long time = date.getTime();

		Timestamp timestamp = new Timestamp(time);
		datalagring.finnledigeBilar(timestamp, timestamp, datalagring.hentUtleigekontor(1)).forEach(System.out::println);
		

		System.out.println();
		System.out.println();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
