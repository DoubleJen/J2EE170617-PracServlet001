package tw.dou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_Prac170701001")
			//http://localhost:8080/Servlet170701_Prac/Prac.php
			//如果請求的URL是『Prac.php』，則由『Servlet_Prac170701001』提供服務
public class Servlet_Prac170701001 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet!!");
		
		response.setContentType("text/html; charset=UTF-8");
			//設定回應內容類型
		try(PrintWriter writer = response.getWriter()){
			//取得回應輸出物件
			writer.write("Hello, World & Java!!");
			writer.println("Hello, Double");
			writer.flush();
		}
	}

	

}
