package tw.dou.j2ee;
//013==>014單檔上傳
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Dou170702014")
@MultipartConfig
public class Dou170702014 extends HttpServlet {
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
			//人家丟上來的字元為UTF-8
		
		//上傳到哪
		String uploadPath = getServletContext().getInitParameter("upload-path");
		//<input type='file' name='upload' />中的upload
		Part part = request.getPart("upload");
		
		//知道原檔名
//		String filename = part.getSubmittedFileName();
				
		String header = part.getHeader("Content-Disposition");
//			out.print(header +"<br>");
//			out.print(BradAPI.getHeaderFileName(header));
		String filename = BradAPI.getHeaderFileName(header);
		out.print("filename ok");
		part.write(uploadPath + "/" + filename);
		out.print("Upload Success");
		
	}

}
