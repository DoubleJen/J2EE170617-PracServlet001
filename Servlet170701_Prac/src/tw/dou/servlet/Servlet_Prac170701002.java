package tw.dou.servlet;
//request.getHeaderNames();
//request.getHeader(String);
//request.getHeaders(String);
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_Prac170701002")
public class Servlet_Prac170701002 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			Enumeration<String> headers = request.getHeaderNames();
			
			while(headers.hasMoreElements()) {
				String header = headers.nextElement();
				String value = request.getHeader(header);
				System.out.println(header + " : " + value);
			}
			
			System.out.println("=================================");
			Enumeration<String> e = request.getHeaders("accept-encoding");
			while(e.hasMoreElements()) {
				String evalue = e.nextElement();
				System.out.println(evalue);
			}
			
			
		}

	
}
