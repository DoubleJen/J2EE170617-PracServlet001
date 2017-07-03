package tw.dou.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

			//路徑
@WebServlet("/Dou170701001")
/////////////////////////////////
public class Dou170701001 extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		System.out.println("doGet");
/////////////////////////////////
		
		
		//Hello, World
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter writer = response.getWriter()){
			//PrintWriter的autoclose
		writer.write("Hello, World");
		writer.flush();
		}
/////////////////////////////////
	
	}

}
