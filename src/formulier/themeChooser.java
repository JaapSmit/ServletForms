package formulier;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class themeChooser
 */
@WebServlet("/themeChooser")
public class themeChooser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				if(cookie.getName().equals("color")){
					request.setAttribute("color", cookie.getValue());
					request.getRequestDispatcher("/WEB-INF/color.jsp").forward(request, response);
					return;
				}
				
			}
		}
		request.getRequestDispatcher("/WEB-INF/colorPicker.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String color = request.getParameter("color");
		Cookie cookie =  new Cookie("color", color);
		response.addCookie(cookie);
		response.sendRedirect("themeChooser");
	}

}
