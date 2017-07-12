package tw.dou.servlet;
//取得Session
//Member=>031、032
//031=>032<=033
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet_Prac170708032")
public class Servlet_Prac170708032 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
 		HttpSession session = request.getSession(false);
 		if(session == null) {
 			out.println("No Session");
 			return;
 		}
 		
 		Servlet_Prac170708031Member member =
 		(Servlet_Prac170708031Member)session.getAttribute("who");
		out.print(member.getName() + " : " + member.getAge());
		//如果想取出Session，則透過HttpSession的getAttribute()就可以取出。
	}


}
