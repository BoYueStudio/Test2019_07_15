package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.Goods;
import com.bean.GoodsType;
import com.service.GoodsService;
import com.service.GoodsTypeService;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.GoodsTypeServiceImpl;


@WebServlet("/addgoods")
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Part part=req.getPart("goods_Pic");
		//获取上传文件的输入流
		InputStream ins=part.getInputStream();
		
		//获取文件名
		String fname=part.getHeader("content-disposition");
		fname=fname.substring(fname.indexOf("filename=")+10,fname.length()-1);
		
		//保存路径，
		String filePath=req.getSession().getServletContext().getRealPath("/")+"\\upfile";
//		System.out.println(filePath);
		
		//输出流写入
		File file=new File(filePath+"\\"+fname);
		
		OutputStream out=new FileOutputStream(file);
		byte[] bs=new byte[1024];
		int len=0;
		while((len=ins.read(bs))!=-1){
			out.write(bs);
			out.flush();
			
		}
		out.close();
		ins.close();
		
		
		String goods_Name=req.getParameter("goods_Name");
		String goods_Price=req.getParameter("goods_Price");
		String goods_Num=req.getParameter("goods_Num");
//		String goods_Pic=req.getParameter("goods_Pic");
		String goods_Type=req.getParameter("goods_Type");
		String desc=req.getParameter("desc");
		String statu=req.getParameter("statu");
		String date=new Date().toLocaleString();
		
		Goods goods=new Goods();
		goods.setGoods_Name(goods_Name);
		goods.setGoods_Price(Double.valueOf(goods_Price));
		goods.setGoods_Num(Integer.valueOf(goods_Num));
		goods.setGoods_Pic("upfile//"+fname);
		goods.setGoods_Type(Integer.valueOf(goods_Type));
		goods.setDesc(desc);
		goods.setStatu(Integer.valueOf(statu));
		goods.setDate(date);
		
		GoodsService gs=new GoodsServiceImpl();

		Boolean bool=false;
		try {
			bool=gs.insertGoods(goods);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bool){
//			resp.getWriter().write("addGoodsServlet获取数据成功!");
			resp.sendRedirect("allgoods");
		}else{
			resp.getWriter().write("addGoodServlet获取数据失败!");
		}
		
		
		
		
		
		
		
		
		
	}

}
