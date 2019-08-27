package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderInfo;
import com.service.OrderInfoService;
import com.service.impl.OrderInfoServiceImpl;

import net.sf.json.JSONObject;



@WebServlet(urlPatterns={"/order"})
public class OrderServlet extends HttpServlet {

	public OrderServlet(){
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
		
		//ordre分页请求
		String method=req.getParameter("method");
		if("pageOrder".equals(method)){
			pageOrder(req,resp);
			return;
		}
		
		if("saleMonth".equals(method)){
			saleMonth(req,resp);
			return;
		}
		
		
		
		
	}
	
	protected void saleMonth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		
		
		
		
		OrderInfoService orderService=new OrderInfoServiceImpl();
		List<Object[]> saleList=orderService.getSaleByMoth();
		List<String> titleList=new ArrayList<String>();
		List<Integer> valueList=new ArrayList<Integer>();
		
		for(Object[] objs: saleList){
			titleList.add(objs[0]+"-"+objs[1]);
			valueList.add(Integer.parseInt(objs[2].toString()));
		}
		HashMap<String,List> saleMap=new HashMap<String,List>();
		saleMap.put("titleList", titleList);
		saleMap.put("valueList", valueList);
		
		String 	res=JSONObject.fromObject(saleMap).toString();
		System.out.println(res);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.print(res);
		out.flush();
		out.close();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	protected void pageOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			Integer pageSize=3;//每页的条数
			Integer onPage=1;//默认第一页
		if(req.getParameter("npage")!=null){
			
			onPage=Integer.parseInt(req.getParameter("npage"));
			
		}
		
		
		
		OrderInfoService orderService=new OrderInfoServiceImpl();
		List<OrderInfo> orderList=orderService.getPageOrder(onPage, pageSize);
		Integer pageCount=orderService.findPageCount(pageSize);
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("orderList", orderList);
		req.setAttribute("onPage", onPage);
		req.getRequestDispatcher("/allorder.jsp").forward(req, resp);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
