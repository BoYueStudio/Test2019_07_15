package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.bean.Goods;
import com.bean.GoodsType;
import com.service.GoodsService;
import com.service.GoodsTypeService;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.GoodsTypeServiceImpl;


@WebServlet(urlPatterns={"/allgoods"})
public class PageGoodsServlet extends HttpServlet {
	 public PageGoodsServlet() {
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
		
		Integer pageSize=2;//ÿҳ������
		Integer onPage=1;//Ĭ�ϵ�һҳ
		
		if(req.getParameter("npage")!=null){
			onPage=Integer.parseInt(req.getParameter("npage"));
			
		}
		GoodsService gs=new GoodsServiceImpl();
		GoodsTypeService gt=new GoodsTypeServiceImpl();
		List<Goods> list=null;//��Ʒ�б�
		List<GoodsType> list2=null;//��Ʒ�����б�
		int pageCount=0;//��ҳ������
		try {
			list=gs.getGoodsPage(onPage, pageSize);
			pageCount=gs.fintGoodsPageCount(pageSize);
			list2=gt.getAllGoodsType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(list2.get(0).getType_Name());
		
		if(list!=null){
//			resp.getWriter().write("AllGoodsServlet��ȡ���ݳɹ�!");
			req.setAttribute("list", list);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("onPage", onPage);
			req.setAttribute("list2", list2);
			System.out.println(list.size());
			req.getRequestDispatcher("/prod_manager.jsp").forward(req, resp);
		}else{
			resp.getWriter().write("AllGoodsServlet��ȡ����ʧ��!");
		}
		
		
	}

}
