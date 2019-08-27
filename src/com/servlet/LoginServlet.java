package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.bean.Address;
import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;

@WebServlet(urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
	
	 public LoginServlet() {
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
		
		//«∞Ã®«Î«Ûµ«¬º
		String method=req.getParameter("method");
		if("frontlogin".equals(method)){
			frontLogin(req,resp);
			return;
		}
		
		if("backlogin".equals(method)){
			backLogin(req,resp);
			return;
		}
		
		if("outfrontlogin".equals(method)){
			outFrontLogin(req,resp);
			return ;
		}
		if("outbacklogin".equals(method)){
			outBackLogin(req,resp);
			return;
		}
		
		
		
		
		
		
		
	}
	
	protected void outBackLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
//		session.invalidate();
		session.setAttribute("rootuser", null);
		resp.sendRedirect("login2.jsp");

			

			
			
		}

protected void outFrontLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	
//	session.invalidate();
	session.setAttribute("user", null);
	resp.sendRedirect("frontallgoods");

		

		
		
	}

	
	
	protected void backLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		UserDao ud=new UserDaoImpl();
		User user=null;
		try {
			user=ud.findUserByName(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null){
			if(user.getPass().equals(upwd) && user.getRole()==1){
				req.getSession().setAttribute("rootuser", user);
				req.getRequestDispatcher("/admin_main.jsp").forward(req, resp);
			}else{
				resp.getWriter().write("<h1>√‹¬Î¥ÌŒÛ!</h1>");
				req.getRequestDispatcher("/login2.jsp").include(req, resp);
			}
		}else{
//			resp.getWriter().write("LoginServlet ß∞‹£°");
			resp.getWriter().write("<h1>”√ªß¥ÌŒÛ!</h1>");
			req.getRequestDispatcher("/login2.jsp").include(req, resp);
		}
		

		
		
	}

	private AddressService as=new AddressServiceImpl();
	protected void frontLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		String member=req.getParameter("member");
		Integer yan=(Integer)req.getSession().getAttribute("yan");
		String yaninput=req.getParameter("yan");
		UserDao ud=new UserDaoImpl();
		User user=null;
		try {
			user=ud.findUserByName(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null){
			
			
			
			
			if(user.getPass().equals(upwd) && (yan+"").equals(yaninput)){
				
				List<Address> addressList=null;
				try{
				addressList=as.findAddressByUid(user.getAdmin_Id());
				}catch (Exception e) {
					e.printStackTrace();
				}
				if("yes".equals(member)){
					Cookie cookie=new Cookie("uname", user.getLogin_Name());
					Cookie cookie2=new Cookie("upwd", user.getPass());
					
					cookie.setMaxAge(60*2);
					cookie2.setMaxAge(60*2);
					resp.addCookie(cookie);
					resp.addCookie(cookie2);
				}else{//«Â≥˝√‹¬Îcookie
					Cookie[] cookies=req.getCookies();
					if(cookies!=null){
						for(Cookie c:cookies){
							if("uname".equals(c.getName())){
								c.setMaxAge(0);
								resp.addCookie(c);
							}
							if("upwd".equals(c.getName())){
								c.setMaxAge(0);
								resp.addCookie(c);
							}
						}
					}
				}
				session.setAttribute("addressList", addressList);
				session.setAttribute("user", user);
				req.getRequestDispatcher("/frontallgoods").forward(req, resp);
			}else{
				resp.getWriter().write("<h1>√‹¬Î¥ÌŒÛ/—È÷§¬Î¥ÌŒÛ!</h1>");
				req.getRequestDispatcher("/front/login.jsp").include(req, resp);
			}
		}else{
//			resp.getWriter().write("LoginServlet ß∞‹£°");
			resp.getWriter().write("<h1>”√ªß¥ÌŒÛ!</h1>");
			req.getRequestDispatcher("/front/login.jsp").include(req, resp);
		}
		

		
		
	}

}
