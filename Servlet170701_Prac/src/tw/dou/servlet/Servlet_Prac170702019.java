package tw.dou.servlet;
//019 forward to 018
//019=>Controller(MV"C")
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170702019")
public class Servlet_Prac170702019 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//轉向 & forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet_Prac170702018");
		
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr />");
		
		//RequestDispatcher有個forward()方法，呼叫時同樣必須傳入請求與回應物件，
		//這表示你要將請求處理轉發給別的Servlet，回應亦轉發給另一個Servlet，
		//要呼叫forward()方法的話，目前的Servlet不能有任何回應確認（Commit），
		//如果在目前的Servlet的有透過回應物件設定了一些回應但未確認（回應緩衝區未滿或未呼叫任何出清方法），
		//則所有回應設定會被忽略，
		//如果已經有回應確認且呼叫了forward()方法，則會丟出IllegalStateException。
		dispatcher.forward(request, response);
		
		out.println("<hr />");
		out.println("Copyleft");
	}


}
