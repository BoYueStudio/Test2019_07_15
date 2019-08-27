package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns={"/pageuser"})
public class PageUserServlet extends HttpServlet {
	
	public PageUserServlet(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		req.setCharacterEncoding("utf-8");
		Integer pageSize=3;//每页的条数
		Integer onPage=1;//默认第一页
		
		if(req.getParameter("npage")!=null){
			onPage=Integer.parseInt(req.getParameter("npage"));
			
		}
		UserService us=new UserServiceImpl();
		List<User> list=us.getUserByPage(onPage,pageSize);
		int pageCount=us.findUserPageCount(pageSize);
		System.out.println("pageCount:"+pageCount);
		System.out.println(list.size());
		
		
		req.setAttribute("list", list);
		req.setAttribute("onPage", onPage);
		req.setAttribute("pageCount", pageCount);
		
		req.getRequestDispatcher("/user_manager.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
