package tw.dou.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Dou170702023")
public class Dou170702023 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		testSQL();
	}
	
	private void testSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//此處必加
			System.out.println("Driver OK");
			
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/double?user=root&password=root");//參數選項用?帶
																				  
			System.out.println("Connection OK");
			
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("insert into cust2(account, passwd) values('brad', '123')");
			stmt.close();
			System.out.println("Insert OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
