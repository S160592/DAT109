package no.hvl.dat109.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {

	public static boolean isGyldigPassord(String passord, String korrektPassord) {
		return passord != null && passord.equals(korrektPassord);
	}
	


	public static boolean isInnloggetSomAdmin(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("innlogget") != null) && (session.getAttribute("username").equals("81549300"));		
	}
	

	public static boolean isInnlogget(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("innlogget") != null);
	}

	public static void loggInnMedTimeout(HttpServletRequest request, int timeoutISekunder) {
		request.getSession().setMaxInactiveInterval(timeoutISekunder);
		request.getSession().setAttribute("innlogget", "JEPP");
		
	}

	

}
