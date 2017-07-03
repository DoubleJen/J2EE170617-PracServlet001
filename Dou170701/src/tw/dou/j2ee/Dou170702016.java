package tw.dou.j2ee;
//轉向016==>017
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Dou170702016")
public class Dou170702016 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
   		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
			//人家丟上來的字元為UTF-8
		
		//轉向
		RequestDispatcher dispatcher = request.getRequestDispatcher("Dou170702017?name=Brad&status=OK");
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("Dou170702018");

		//include
		dispatcher.include(request, response);
		out.println("<hr />");
		dispatcher2.include(request, response);
		
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr/>");
		
		out.println("<hr/>");
		out.println("Copyleft");
   	
   	
   	}



}
