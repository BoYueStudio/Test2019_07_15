package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Goods;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

@WebServlet(urlPatterns={"/updategoods"})
public class UpdateGoodsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Integer goods_Id=Integer.parseInt(req.getParameter("goods_Id"));
		String goods_Name=req.getParameter("goods_Name");
		Integer goods_Num=Integer.parseInt(req.getParameter("goods_Num"));
		Double goods_Price=Double.parseDouble(req.getParameter("goods_Price"));
		Integer goods_Type=Integer.parseInt(req.getParameter("goods_Type"));
		String goods_Pic=req.getParameter("goods_Pic");
		String desc=req.getParameter("desc");
		Integer statu=Integer.parseInt(req.getParameter("statu"));
		String date=req.getParameter("date");
		Goods goods=new Goods(goods_Id, goods_Name, goods_Price, goods_Num, goods_Pic, goods_Type, desc, statu, date);
		
		GoodsService gs=new GoodsServiceImpl();
		Boolean bool=false;
		try {
			bool=gs.updateGoods(goods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bool){
			resp.sendRedirect("allgoods");
		}else {
			resp.getWriter().write("UpdateGoodsServlet ß∞‹!");
		}
	}

}
