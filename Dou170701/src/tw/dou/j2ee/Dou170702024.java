package tw.dou.j2ee;
//https://github.com/jeremyh/jBCrypt
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170702024")
public class Dou170702024 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salt = BCrypt.gensalt(12);
		String newpasswd = BCrypt.hashpw("123456", salt);//產生亂碼
		System.out.println(newpasswd);
		
		if(ckPasswd("123456", newpasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	}

	private static boolean ckPasswd(String orgPasswd, String hashPasswd){
		boolean isRight = false;
		if(hashPasswd == null || !hashPasswd.startsWith("$2a$")) {
			isRight = false;
		}
		isRight = BCrypt.checkpw(orgPasswd, hashPasswd);
		return true;
	}
}
