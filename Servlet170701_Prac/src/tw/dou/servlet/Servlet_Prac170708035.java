package tw.dou.servlet;
//週期任務
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170708035")
public class Servlet_Prac170708035 extends HttpServlet {
	private int i;
			//i=0
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		new Timer().schedule(new MyTask(), 5000, 1000);
	}
	
	private class MyTask extends TimerTask{
		@Override
		public void run() {
			System.out.println(i++);
		}
	}


}
