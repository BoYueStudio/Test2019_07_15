package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

@WebServlet(urlPatterns={"/alluser"})
public class AllUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		UserService us=new UserServiceImpl();
		List<User> list=null;
		try {
			list=us.getAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list!=null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("/alluser.jsp").forward(req, resp);
		}else{
			System.out.println("error");
		}
	}
}
