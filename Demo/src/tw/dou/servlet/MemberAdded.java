package tw.dou.servlet;
// Member Added <=> Member Query & Delete <=> Member Update

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberAdded")
public class MemberAdded extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");	
		String passwd = request.getParameter("passwd");
		String realname = request.getParameter("realname");
		
		//Add member Data and return
		if(account != null) {
			addAccount(account, passwd, realname);
			response.sendRedirect("MemberQueryDel.jsp");
		}
		
	}
	
	private void addAccount(String account, String passwd, String realname) {
		String salt = BCrypt.gensalt();
		try {
			//Driver import
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection OK!!!");
			
			//Build Connection
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doubleprac", prop);
			System.out.println("Connection OK!!!");
			
			//SQL
			PreparedStatement pstmt=
			conn.prepareStatement("insert into member(account, passwd, realname) values(?, ?, ?)");
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, salt));
			pstmt.setString(3, realname);
			pstmt.executeUpdate();
			System.out.println("Insert OK!!!");
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}
