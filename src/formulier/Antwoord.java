package formulier;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Antwoord
 */
@WebServlet("/Antwoord")
public class Antwoord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		response.getWriter()
		.append("<!DOCTYPE html><html><head></head><body>" +
				returnResult(request) +
				"</body></html>");
		*/
		request.setAttribute("totaal", returnResult(request));
		request.getRequestDispatcher("/WEB-INF/Antwoord2.jsp").forward(request, response);
	}
	
	
	String returnResult(HttpServletRequest request) {
		if(checkResult(request)) {
			int getal1 = Integer.parseInt(request.getParameter("getal1"));
			int getal2 = Integer.parseInt(request.getParameter("getal2"));
			String operatie = request.getParameter("operatie");
			int totaal = 0;
			switch(operatie) {
				case "plus":
					totaal = getal1 + getal2;
					break;
				case "min":
					totaal = getal1 - getal2;
					break;
				case "vermenigvuldig":
					totaal = getal1 * getal2;
					break;
				case "delen":
					if(getal2 == 0) return "NaN";
					totaal = getal1 / getal2;
			}
			String tmpTotaal = "Totaal van " + getal1 + " " + operatie + " " + getal2 + " = " +totaal;
			addToSession(request, tmpTotaal);
			return tmpTotaal;
		} else {
			return "Ongeldige getallen";
		}
	}
	
	boolean checkResult(HttpServletRequest request) {
		if(request.getParameter("getal1").isEmpty()) return false;
		if(request.getParameter("getal2").isEmpty()) return false;
		return true;
	}
	
	void addToSession(HttpServletRequest request, String tot) {
		HttpSession session = request.getSession();
		ArrayList<String> calcs = (ArrayList)session.getAttribute("lastCalculations");
		calcs.add(tot);
		if(calcs.size() > 5) {
			calcs.remove(0);
		}
	}



}
