package tw.dou.j2ee;
//009==>010
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dou170701010
 */
@WebServlet("/Dou170701010")
public class Dou170701010 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gender = request.getParameter("gender");
		
//		String hobby = request.getParameter("hobby");
		String[] hobby =  request.getParameterValues("hobby");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(gender);
		StringBuffer sb = new StringBuffer();
		for(String h : hobby) {
			sb.append(h + " ");
		}
		response.getWriter().write(sb.toString());
		
	}


}
