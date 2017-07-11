package tw.dou.servlet;
//Use Servlet to draw Image 025=>026
//1. BufferedImage bimg = new BufferedImage(int width, int height, int imageType);
//2. Graphics2D g2d = bimg.createGraphics();
//3. g2d.setBackground v.s. g2d.clearRect & g2d.setColor v.s. g2d.fillRect
//4. ImageIO.write(RenderedImage im, String formatName,OutputStream output);
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Prac170708025")
public class Servlet_Prac170708025 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String rate = request.getParameter("rate");
		float floatrate = Float.parseFloat(rate);
		
		//Start Draw
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bimg.createGraphics();
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 400, 20);
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int)(400*floatrate/100), 20);
		
		//Output to HttpResponse
		OutputStream out = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", out);
		out.flush();
		out.close();
		
		
		
	}


}
