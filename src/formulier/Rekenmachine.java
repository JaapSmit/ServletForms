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
 * Servlet implementation class Rekenmachine
 */
@WebServlet("/Rekenmachine")
public class Rekenmachine extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		response.getWriter()
		.append("<!DOCTYPE html><html><head></head><body>" +
				"<form action=\"Antwoord\">" + 
				"<input type=\"text\" name=\"getal1\" />" +
				"<select name=\"operatie\">" +
					"<option value=\"plus\"> plus </option>" +
					"<option value=\"min\"> min </option>" +
					"<option value=\"vermenigvuldig\"> vermenigvuldig met</option>" +
					"<option value=\"delen\"> delen door </option>" +
				"</select> <br>" +
				"  <input type=\"text\" name=\"getal2\" />" +

				"<input type=\"submit\" value=\"submit\" /></form>" +
				"</body></html>");
		*/
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			ArrayList<String> lastCalculations = new ArrayList<>();
			for(int i = 0; i < 5; i++) {
				lastCalculations.add("");
			}
			session = request.getSession();
			session.setAttribute("lastCalculations", lastCalculations);
		} else {
			ArrayList<String> calcs = (ArrayList)session.getAttribute("lastCalculations");
			request.setAttribute("antwoord1", calcs.get(0));
			request.setAttribute("antwoord2", calcs.get(1));
			request.setAttribute("antwoord3", calcs.get(2));
			request.setAttribute("antwoord4", calcs.get(3));
			request.setAttribute("antwoord5", calcs.get(4));
		}
		
		
		request.getRequestDispatcher("/WEB-INF/Antwoord.jsp").forward(request, response);
	}


}
