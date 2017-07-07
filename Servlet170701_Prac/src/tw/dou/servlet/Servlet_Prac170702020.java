package tw.dou.servlet;
//Controller(MV"C")
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170702020")
public class Servlet_Prac170702020 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//0.Prepare控管資料
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if(x == null) x="0";
		if(y == null) y="0";
		
		//1.引用Model處理邏輯(引用021Model)
		Servlet_Prac170702021 model = new Servlet_Prac170702021(x, y);
		int result = model.add();
		
		//2.View以forward透過"Servlet_Prac170702022"來實現
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("Servlet_Prac170702022").forward(request, response);
	}


}
