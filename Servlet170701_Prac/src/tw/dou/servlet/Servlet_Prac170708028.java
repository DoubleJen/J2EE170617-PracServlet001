package tw.dou.servlet;
//建立Cookie&有效期限
//028=>028_01
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170708028")
public class Servlet_Prac170708028 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//建立Cookie、設定有效期限、在response中新增Cookie物件
		Cookie cookieRemember = new Cookie("remember", "true");
									//使用Cookie類別，建立時指定Cookie中的名稱與數值
		cookieRemember.setMaxAge(1*60);
					   //設定Cookie的有效期限，設定的單位是「秒」
		response.addCookie(cookieRemember);
		
		Cookie cookieAccount = new Cookie("account", "brad");
		cookieAccount.setMaxAge(1*60);
		response.addCookie(cookieAccount);
		
		Cookie cookiePasswd = new Cookie("passwd", "123456");
		cookiePasswd.setMaxAge(1*60);
		response.addCookie(cookiePasswd);
		
		
		
	}


}
