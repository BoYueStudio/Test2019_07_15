package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns={"/regist"})
public class RegistServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String upet=req.getParameter("upet");
		String upwd=req.getParameter("upwd");
		
		User user=new User();
		user.setLogin_Name(uname);
		user.setPet_Name(upet);
		user.setPass(upwd);
		user.setRole(2);
		user.setStatu(1);
		user.setReg_Date(new Date().toLocaleString());
		
		UserService ud=new UserServiceImpl();
		
		User inUser=null;	

		try {
			inUser=ud.findUserByName(uname);//根据注册名查找数据库是否存在相同的
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(inUser==null){//可以注册
			try {
				if(ud.addUser(user)){
					resp.getWriter().write("<h1>注册成功,请登录!</h1>");
					req.getRequestDispatcher("/front/login.jsp").include(req, resp);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{//不可用注册
			resp.getWriter().write("<h1>用户已存在,请重新注册!</h1>");
			req.getRequestDispatcher("/front/regist.jsp").include(req, resp);
		}
		
		
		
	}

}
