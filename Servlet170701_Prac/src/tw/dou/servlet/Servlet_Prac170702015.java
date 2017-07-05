package tw.dou.servlet;
//013=>015 multiple file upload
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Servlet_Prac170702015")
@MultipartConfig
public class Servlet_Prac170702015 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//上傳到哪
		String uploanPath = getServletContext().getInitParameter("upload-path");
		
		//抓取檔名&寫入Project
		Collection<Part> parts = request.getParts();
		for(Part part: parts) {
			String header = part.getHeader("Content-Disposition");
			out.print(header + "<br>");	
			String filename = BradAPI_170702.getHeaderFileName(header);
			out.println(filename + "<br>");
			if(filename != null && filename.length() > 0) {
			part.write(uploanPath + "/" + filename); 
			}
			out.println("<hr>");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
