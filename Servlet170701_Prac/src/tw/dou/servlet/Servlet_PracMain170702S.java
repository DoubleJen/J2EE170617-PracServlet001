package tw.dou.servlet;
//Main170702S=>AddACCOUNT170702S
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_PracMain170702S")
public class Servlet_PracMain170702S extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			Connection conn = 
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doubleprac", prop);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from cust2");
			rs = pstmt.executeQuery();
			
			String delid =  request.getParameter("delid");
			if(delid !=  null) {
				conn.createStatement().executeUpdate("delete from cust2 where id = " + delid );
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		out.println("<a href='Servlet_PracMainAddACCOUNT170702S'>Add</a>");
		out.println("<hr>");
		out.println("<table border='1' width='100%'>" + 
				"	<tr>\r\n" + 
				"		<th>ID</th>\n" + 
				"		<th>Name</th>\n" + 
				"		<th>Password</th>\n" + 
				"		<th>Delete</th>\n" +
				"	</tr>"); 
				
		try{	
			if(rs!=null) {
				while(rs.next()) {
					String id = rs.getString("id");
					String account = rs.getString("account");
					String passwd = rs.getString("passwd");
					out.println("<tr>");
					out.println("<td>" + id + "</td>");
					out.println("<td>" + account + "</td>");
					out.println("<td>" + passwd + "</td>");
					out.println("<td><a href='?delid=" + id + "' onclick='return confirm(\"Delete" + account + " \");'>DELETE</a></td>");
					out.println("</tr>");
				}
			}
		}catch(Exception e) {
		}
		
		out.println("</table>");
	}


}
