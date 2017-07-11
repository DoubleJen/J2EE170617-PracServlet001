package tw.dou.servlet;
//Use Servlet to read Image & modify
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170708027")
public class Servlet_Prac170708027 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String imgPath = getServletContext().getInitParameter("upload-path");
		File inFile = new File(imgPath, "Desert.jpg");
		BufferedImage bimg = ImageIO.read(inFile);
		Graphics2D g2d = bimg.createGraphics();
		
		//Start Draw
		Font font = new Font(null, Font.BOLD+Font.ITALIC, 48);

			//Transform
			AffineTransform tran = new AffineTransform();
			tran.rotate(Math.toRadians(-30), 100, 0);
						//Math.toRadians(-30)
						//轉換為大致相等的角度(以弧度為單位)
						//正=順時針，負=逆時針
			Font newfont = font.deriveFont(tran);
						//Creates a new Font object by replicating the current Font object 
						//and applying a new transform to it.
			
			
		g2d.setFont(newfont);
		g2d.setColor(Color.RED);
		g2d.drawString("Hello資策會", 100, 150);
		
		//Output to HTTP
		OutputStream out =  response.getOutputStream();
		ImageIO.write(bimg, "jpg", out);
		//Output to file
		File outFile = new File(imgPath, "Desertdemo170708.jpg");
		ImageIO.write(bimg, "jpg", outFile);
		
		out.flush();
		out.close();
		
	}


}
