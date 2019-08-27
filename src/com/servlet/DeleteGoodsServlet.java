package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;
@WebServlet(urlPatterns={"/deletegoods"})
public class DeleteGoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Integer id=Integer.parseInt(req.getParameter("id"));
		GoodsService gs=new GoodsServiceImpl();
		Boolean bool=false;
		try {
			bool=gs.deleteGoodsById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bool){
			resp.sendRedirect("allgoods");
		}else{
			resp.getWriter().write("DeleteGoodsServlet ß∞‹£°");
		}
	}

}
