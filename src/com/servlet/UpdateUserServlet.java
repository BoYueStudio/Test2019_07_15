package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet(urlPatterns = { "/updateuser" })
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname");
		String oldpwd = req.getParameter("oldpwd");
		String newpwd = req.getParameter("newpwd");
		System.out.println(uname);
		UserService ud=new UserServiceImpl();
		User user = null;
		try {
			user = ud.findUserByName(uname);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (!user.getPass().equals(oldpwd)) {
			resp.getWriter().write("<h1>æ…√‹¬Î¥ÌŒÛ,«Î÷ÿ ‘!</h1>");
			req.getRequestDispatcher("/updateuser.jsp").include(req, resp);
		} else {
			Boolean bool=false;
			try {
				user.setPass(newpwd);
				bool=ud.updateUserById(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(bool){
				resp.getWriter().write("<h1>√‹¬Î–ﬁ∏ƒ≥…π¶!</h1>");

			}else{
				resp.getWriter().write("<h1>UpdateUserServlet ß∞‹£°</h1>");

			}
			
			
		}

	}

}
