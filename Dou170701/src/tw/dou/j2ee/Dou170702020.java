package tw.dou.j2ee;
//I am Controller(MV"C")
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170702020")
public class Dou170702020 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		// 0. Prepare管控資料
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if(x == null) x="0";
		if(y == null) y="0";
		
		// 1. Model處理(邏輯所在)
		Dou170702021 model = new Dou170702021(x, y);
		int result = model.add();
		
		// 2. View: through forward call View導
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("Dou170702022").forward(request, response);
		
		
		
	}


}
