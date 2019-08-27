package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.bean.Address;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;

@WebServlet(urlPatterns={"/address"})
public class AddressServlet extends HttpServlet {
	public AddressServlet(){
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
		if("addAddress".equals(method)){
			addAddress(req,resp);
		}
	}
	private AddressService as=new AddressServiceImpl();
	protected void addAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		String userId=req.getParameter("userId");
		String a_name=req.getParameter("addressName");
		String a_address=req.getParameter("address");
		String a_phone=req.getParameter("addressPhone");
		System.out.println("ÎÒµÄµØÖ·£º"+a_address);
		Address address=new Address();
		address.setAddress(a_address);
		address.setDress_Name(a_name);
		address.setAddress_Phone(a_phone);
		address.setAdmins_Id(Integer.parseInt(userId));
		
		Boolean bool=as.insertAddress(address);
		if(bool){
			List<Address> addressList=null;
			try{
			HttpSession session=req.getSession();
			addressList=as.findAddressByUid(Integer.parseInt(userId));
			session.setAttribute("addressList", addressList);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			req.getRequestDispatcher("/front/address.jsp").forward(req, resp);
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
