package no.hvl.dat109.Servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Classes.Finnting;
import no.hvl.dat109.Entity.Bil;
import no.hvl.dat109.Interfaces.PersistentBil;
import no.hvl.dat109.Interfaces.PersistentUtleigekontor;

@WebServlet({ "/index.html" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PersistentBil bilEAO;
	@EJB
	private PersistentUtleigekontor utleigekontorEAO;
	@EJB
	private Finnting hentData;
	
	public Index() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date date = new Date();

		long time = date.getTime();

		Timestamp timestamp = new Timestamp(time);

		Bil bil = bilEAO.hentBil(request.getParameter("regnr"));
		int utleigekontor = Integer.valueOf(request.getParameter("kontor"));
		bil.setUtleigekontor(utleigekontorEAO.hentUtleigekontor(utleigekontor));
		bilEAO.update(bil);

		
		
		List<Bil> ledigeBilar = hentData.finnledigeBilar(timestamp, timestamp, utleigekontorEAO.hentUtleigekontor(1));
	
		ledigeBilar.forEach(System.out::println);
		System.out.println();
		System.out.println();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
