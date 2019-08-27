package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/servletimg"})
public class LoginImg extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		BufferedImage img=new BufferedImage(90,30,BufferedImage.TYPE_INT_RGB);
		Graphics g= img.getGraphics();
		g.setColor(Color.red);
		g.setFont(new Font("", Font.ITALIC, 26));
		Integer yan=(int)(Math.random()*100000);
		g.drawString(yan+"", 10, 20);
		g.drawLine(10, 10, 80, 0);
		g.drawLine(0, 20, 77, 10);
		
		ImageIO.write(img,"jpg", resp.getOutputStream());
		
		req.getSession().setAttribute("yan", yan);
		
	}

}
