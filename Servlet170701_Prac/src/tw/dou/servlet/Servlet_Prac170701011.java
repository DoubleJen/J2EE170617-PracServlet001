package tw.dou.servlet;
////012=>011
//Part part = request.getPart(String);
//String filename = part.getSubmittedFileName();
//String name = part.getName();
//long size = part.getSize();
//part.getInputStream();
//ServletContext context = getServletContext();
//String uploadPath = context.getInitParameter("upload-path");==>web.xml <param-name>upload-path</param-name>
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Servlet_Prac170701011")
@MultipartConfig
public class Servlet_Prac170701011 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//getPart()方法接受一個字串，代表著檔案上傳欄位的name屬性
		Part part = req.getPart("fileupload");
		Collection<String> cc = part.getHeaderNames();
		for(String header: cc) {
			String v = part.getHeader(header);
			out.println(header + " : " + v + "<br>");
		}
		
		//part.getSubmittedFileName()，用於取得客戶端上傳的文件名
		String filename = part.getSubmittedFileName();
		out.print("<hr>");
		out.print(filename + "<br>");
		
		//part.getName()，文件上傳表單的name屬性的值
		String name = part.getName();
		long size = part.getSize();
		out.print("<hr>");
		out.print(name + " : " + size + "<br>");
		
		//讀取資料
		//getInputStream()可以取得代表上傳檔案區段的檔案內容之輸入串流
		//https://openhome.cc/Gossip/JavaGossip-V2/BufferedInOutStream.htm
		byte[] buf = new byte[(int)size];
		BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
		bin.read(buf);
		bin.close();
		
		//可以使用ServletContext實作物件來取得所請求資源的URL、設定與儲存屬性、應用程式初始參數，
		//甚至動態設定Servlet實例。
		//https://openhome.cc/Gossip/ServletJSP/ServletContext.html
		ServletContext context = getServletContext();
		String uploadPath = context.getInitParameter("upload-path");
		FileOutputStream fout = new FileOutputStream(new File(uploadPath, filename));
		fout.write(buf);
		fout.close();
	}

}
