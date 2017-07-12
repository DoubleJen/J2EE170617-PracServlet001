package tw.dou.servlet;
//建立Session
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

@WebServlet("/Servlet_Prac170708031")
public class Servlet_Prac170708031 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();//如果當前沒有Session，則創建一新Session
//		HttpSession session = request.getSession(true);//等同於request.getSession();
//		HttpSession session = request.getSession(false);//等同於如果當前沒有Session，傳回null=>redirect to another page
		
		Servlet_Prac170708031Member member = new Servlet_Prac170708031Member("brad", 51);
		session.setAttribute("who", member);
		// 如果想要在瀏覽器與Web應用程式的會話期間，保留請求之間的相關訊息，
		//則可以使用HttpSession的setAttribute()方法將相關訊息設置為屬性。
		
		
	}


}
