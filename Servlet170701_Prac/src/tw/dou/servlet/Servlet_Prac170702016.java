package tw.dou.servlet;
//016 include 017, 018
//RequestDispatcher dispatcher = request.getRequestDispatcher(String URL);
//dispatcher.include(request, response);
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170702016")
public class Servlet_Prac170702016 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//轉向 & include
		//呼叫HttpServletRequest的getRequestDispatcher()時需要傳入一個相對於目前請求URL的路徑資訊。
		RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet_Prac170702017?name=Brad&status=OK");
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("Servlet_Prac170702018");	
		
		//RequestDispatcher上有個include()方法，可以讓你『將另一個Servlet回應包括至目前的回應之中』。
		dispatcher.include(request, response);
		out.println("<hr />");
		dispatcher2.include(request, response);
		
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr />");
		out.println("<hr />");
		out.println("Copyleft");
	}

}
