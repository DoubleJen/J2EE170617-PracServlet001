package tw.dou.j2ee;
//生命週期
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dou170701003
 */
@WebServlet("/Dou170701003")
public class Dou170701003 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
    public Dou170701003() {
        super();
        System.out.println("Dou170701003()");
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		super.service(request, response);
		System.out.println("service");
		doGet(request, response);
		doPost(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
