package tw.dou.j2ee;
//019==>018 MVC的精神
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Dou170702019")
public class Dou170702019 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
			//人家丟上來的字元為UTF-8
		
		//轉向
		RequestDispatcher dispatcher = request.getRequestDispatcher("Dou170702018");
		
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr/>");
		
		//forward
		dispatcher.forward(request, response);
		
		out.println("<hr/>");
		out.println("Copyleft");
	}

	
}
