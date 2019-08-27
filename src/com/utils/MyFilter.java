package com.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns={"/*"},filterName="loginfilter")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();

		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI().toString();
		String requestType = url.substring(url.lastIndexOf("/") + 1);
		String method = request.getParameter("method");

		// System.out.println("地址：" + url);
		// 前台过滤
		if ("cargoods".equals(requestType) && "settlement".equals(method) || "address.jsp".equals(requestType)) {// 前台过滤
			if (session.getAttribute("user") != null) {
				arg2.doFilter(arg0, arg1);

				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/front/login.jsp");
			}
			// 后台过滤

		} else if ("admin_main.jsp".equals(requestType) || "allgoods".equals(requestType)
				|| "pageuser".equals(requestType) || "order".equals(requestType) || "details".equals(requestType)) {
			if (session.getAttribute("rootuser") != null) {

				arg2.doFilter(arg0, arg1);

				return;
			} else {
				response.sendRedirect("login2.jsp");
			}

		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
