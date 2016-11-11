package formulier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ontvanger
 */
@WebServlet("/Ontvanger")
public class Ontvanger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		response.getWriter().append("<!DOCTYPE html><html><head>" + 
				"</head><body><h1>Hallo " + request.getParameter("textinput") + "</h1>" +
				"</body></html>");
		*/
		response.sendError(Integer.parseInt(request.getParameter("textinput")));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

/* " + request.getParameter(textinput) + " */
