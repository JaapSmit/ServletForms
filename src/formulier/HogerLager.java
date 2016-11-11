package formulier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
/**
 * Servlet implementation class HogerLager
 */
@WebServlet("/HogerLager")
public class HogerLager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static int secret;
	private static int tries;
	private static String antwoord;
	
	public void init() {
		Random r = new Random();
		secret = r.nextInt(101);
		antwoord = "succes";
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("guess") != null) {
			int intGuess;
			if(request.getParameter("guess") == "") {
				intGuess = 0;
			} else {
				intGuess = Integer.parseInt(request.getParameter("guess"));
			}
			if(intGuess < secret) {
				antwoord = "Hoger";
				tries++;
			}
			else if(intGuess > secret) {
				antwoord = "Lager";
				tries++;
			}
			else {
				antwoord = "WHOEOEOEOEHEHEOEOE GERADEN!!";
				Random r = new Random();
				secret = r.nextInt(101);
				tries = 0;
			}
		}
		
		response.getWriter().
		append("<!DOCTYPE html><html><head></head><body>" +
				"<form>" + 
				"Voer hier je nummer in: <input type=\"text\" name=\"guess\" autofocus />" +
				"<input type=\"submit\" value=\"submit\" /></form>" +
				antwoord +
				"<br> Je hebt het al " + tries + " keer geprobeerd" +
				"</body></html>");
	}


}
