package formulier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatusCode
 */
@WebServlet("/StatusCode")
public class StatusCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter()
		.append("<!DOCTYPE html><html><head></head><body>" +
				"<form action=\"Ontvanger\">" + 
				"<input type=\"radio\" name=\"textinput\" value=\"200\"> 200 <br>" +
				"<input type=\"radio\" name=\"textinput\" value=\"400\"> 400 <br>" +
				"<input type=\"radio\" name=\"textinput\" value=\"404\"> 404 <br>" +
				"<input type=\"radio\" name=\"textinput\" value=\"418\"> 418 <br>" +
				"<input type=\"radio\" name=\"textinput\" value=\"500\"> 500 <br>" +
				"<input type=\"submit\" value=\"submit\"></form>" +
				"</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
