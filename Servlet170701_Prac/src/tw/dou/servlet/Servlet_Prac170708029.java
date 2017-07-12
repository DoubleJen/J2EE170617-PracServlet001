package tw.dou.servlet;
//取得Cookie
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170708029")
public class Servlet_Prac170708029 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		Cookie[] cookies = request.getCookies();
						   //取得屬於該網頁所屬網域（domain）的所有Cookie，所以傳回值是Cookie[]陣列。
		HashMap<String, String> map = new HashMap<>();
		
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				//使用Cookie的getName()與getValue()方法，分別取得Cookie的名稱與數值。
				
				map.put(name, value);
			}
		}
		
		if(map.containsKey("remember")) {
			if(map.get("remember").equals("true")) {
				out.print(map.get("account") + " : " + map.get("passwd"));
			}else {
				out.print("No Remember");
			}
		}else {
			out.print("No Cookie");
		}
		
		
	}

}
