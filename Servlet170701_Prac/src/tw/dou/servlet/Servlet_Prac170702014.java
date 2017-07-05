package tw.dou.servlet;
//013=>014 single file upload
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Servlet_Prac170702014")
@MultipartConfig
public class Servlet_Prac170702014 extends HttpServlet {
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
			//使用HttpServletRequest的setCharacterEncoding()方法，
			//指定取得POST請求參數時使用的編碼。
			//例如若瀏覽器以UTF-8來發送請求，則你接收時也要使用UTF-8編碼字串，
			//則可以在取得任何請求值之「前」，執行以下陳述：request.setCharacterEncoding("UTF-8");
			//一定要在取得任何請求參數前執行setCharacterEncoding()方法才有作用！
			
			//這個方法對於請求本體中的字元編碼才有作用，也就是基本上這個方法只對POST產生作用，
			//當請求是用GET發送時則沒有定義這個方法是否會影響 Web容器處理編碼的方式
			
			//如果你要接收中文請求參數並在回應時於瀏覽器正確顯示中文，
			//必須同時設定HttpServletRequest的 setCharacterEncoding()
			//以及HttpServletResponse的setCharacterEncoding()或 setContentType()
			//為正確的編碼。
			//https://openhome.cc/Gossip/Encoding/Servlet.html
		
		//上傳到哪
		String uploadPath = getServletContext().getInitParameter("upload-path");
		
		//抓取檔名&寫入Project
		Part part = request.getPart("sfileupload");	
		String header = part.getHeader("Content-Disposition");
			//Content-Disposition可以控制使用者儲存檔案時的檔案名稱。
			//https://medium.com/@hyWang/%E5%A6%82%E4%BD%95%E5%9C%A8%E4%B8%8D%E5%90%8C%E7%80%8F%E8%A6%BD%E5%99%A8%E4%B8%8B%E8%BC%89%E6%AD%A3%E7%A2%BA%E7%9A%84%E6%AA%94%E6%A1%88%E5%90%8D%E7%A8%B1-content-disposition-7ef13555b1ba
		out.print(header + "<br>");	
		String filename = BradAPI_170702.getHeaderFileName(header);
		out.println(filename + "<br>");
		out.println("filename ok" + "<br>");
		part.write(uploadPath + "/" + filename);
		out.print("Upload Success");
		
		
		
	}	

}
