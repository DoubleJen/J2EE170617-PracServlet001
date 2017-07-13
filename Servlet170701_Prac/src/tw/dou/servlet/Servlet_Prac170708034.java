package tw.dou.servlet;
//執行緒
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170708034")
public class Servlet_Prac170708034 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
						
			new Thread(()->{
				out.println("OK");
				for (int i=0; i<20; i++) {
					out.println("OK" + i);
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}).start();
			//執行緒不會在前景跑, 但可在背後跑
			
	}

	
}
