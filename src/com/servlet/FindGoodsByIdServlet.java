package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Goods;
import com.bean.GoodsType;
import com.service.GoodsService;
import com.service.GoodsTypeService;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.GoodsTypeServiceImpl;

@WebServlet(urlPatterns={"/findgoodsbyid"})
public class FindGoodsByIdServlet extends HttpServlet{
	
	 public FindGoodsByIdServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String method=req.getParameter("method");
		if("findGoodsById".equals(method)){
			fintGoodsById(req,resp);
		}
		
		if("detailId".equals(method)){
			detailId(req,resp);
		}
		
	}
	
	
	protected void fintGoodsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Integer id=Integer.parseInt(req.getParameter("id"));
		GoodsService gs=new GoodsServiceImpl();
		GoodsTypeService gt=new GoodsTypeServiceImpl();
		Goods goods=null;
		GoodsType goodsType=null;
		try {
		goods=gs.findGoodsById(id);
		goodsType=gt.findGoodsTypeById(goods.getGoods_Type());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(goodsType.getType_Name());
		if(goods!=null){
			req.setAttribute("goods", goods);
			req.setAttribute("gtype", goodsType);
			req.getRequestDispatcher("/findgoodsbyid.jsp").forward(req, resp);
		}else{
			resp.getWriter().write("FindGoodsByIdServlet ß∞‹£°");
		}
	}

	protected void detailId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Integer id=Integer.parseInt(req.getParameter("id"));
		GoodsService gs=new GoodsServiceImpl();
		GoodsTypeService gt=new GoodsTypeServiceImpl();
		Goods goods=null;
		GoodsType goodsType=null;
		try {
		goods=gs.findGoodsById(id);
		goodsType=gt.findGoodsTypeById(goods.getGoods_Type());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(goodsType.getType_Name());
		if(goods!=null){
			req.setAttribute("goods", goods);
			req.setAttribute("gtype", goodsType);
			req.getRequestDispatcher("/front/goodsDetails.jsp").forward(req, resp);
		}else{
			resp.getWriter().write("FindGoodsByIdServlet ß∞‹£°");
		}
	}

}
