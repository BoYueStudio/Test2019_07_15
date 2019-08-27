package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderDetails;
import com.dao.OrderDatilsDao;
import com.dao.impl.OrderDatilsDaoImpl;

@WebServlet(urlPatterns={"/details"})
public class DetailsServlet extends HttpServlet {

	public DetailsServlet(){
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
		
		//details分页请求
		String method=req.getParameter("method");
		if("pageDetails".equals(method)){
			pageDetails(req,resp);
			return;
		}
		
		
		
	}
	protected void pageDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			Integer pageSize=3;//每页的条数
			Integer onPage=1;//默认第一页
		if(req.getParameter("npage")!=null){
			
			onPage=Integer.parseInt(req.getParameter("npage"));
		}
		
		
		OrderDatilsDao od=new OrderDatilsDaoImpl();
		List<OrderDetails> detailsList=od.getPageDetails(onPage, pageSize);
		Integer pageCount=od.findPageCount(pageSize);
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("detailsList", detailsList);
		req.setAttribute("onPage", onPage);
		req.getRequestDispatcher("/alldetails.jsp").forward(req, resp);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		}
	
}
