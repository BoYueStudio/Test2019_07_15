package com.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns={"/frontallgoods"})
public class AllGoodsServlet extends HttpServlet {
	
	public AllGoodsServlet(){
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
		req.setCharacterEncoding("utf-8");
		GoodsService gs=new GoodsServiceImpl();
		GoodsTypeService gt=new GoodsTypeServiceImpl();
		List<Goods> list=null;//商品列表
		List<GoodsType> list2=null;//商品类型列表

		try {
			list=gs.getAllGoods();
			list2=gt.getAllGoodsType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(list2.get(0).getType_Name());
		
		if(list!=null){
//			resp.getWriter().write("AllGoodsServlet获取数据成功!");
			req.setAttribute("list", list);
			req.setAttribute("list2", list2);
			System.out.println(list.size());
			req.getRequestDispatcher("/front/index.jsp").forward(req, resp);
		}else{
			resp.getWriter().write("AllGoodsServlet获取数据失败!");
		}
		
		
	
		
		
	}

}
