package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Address;
import com.bean.CarGoods;
import com.bean.Goods;
import com.bean.OrderInfo;
import com.bean.User;
import com.service.AddressService;
import com.service.GoodsService;
import com.service.OrderInfoService;
import com.service.impl.AddressServiceImpl;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.OrderInfoServiceImpl;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet(urlPatterns={"/cargoods"})
public class CarGoodsServlet extends HttpServlet {
	
	public CarGoodsServlet(){
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
		
		if("addcar".equals(method)){
			addGoodsToCar(req,resp);
			return;
		}
		
		if("settlement".equals(method)){
			
			settlementCar(req,resp);
			return;
		}
		
		if("doBuy".equals(method)){
			doBuy(req,resp);
			return;
		}
	}

	protected void doBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ddddd");
		try{
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");
		

		HttpSession session2=req.getSession();//请求sesseion中支付的商品list


		
		List<CarGoods> carGoodsList=(List<CarGoods>) session2.getAttribute("carGoodsList");//已确定购买的商品list
		HashMap<Integer,CarGoods> goodsCarMap=(HashMap<Integer, CarGoods>) session.getAttribute("goodsCarMap");//购物车商品列表
		Double totlePrice=0.0;
		if(carGoodsList.size()>0){
			for(CarGoods car: carGoodsList){
				
				
				totlePrice+=car.getNum()*car.getGoods().getGoods_Price();//计算总价格
				goodsCarMap.remove(car.getGoods().getGoods_Id());//清除购物车中已购买的商品
			}
		}
		String remark=req.getParameter("remark");
		//设置订单
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setTotal(totlePrice);
		orderInfo.setU_id(user.getAdmin_Id());
		orderInfo.setBeizhu(remark);
		
		
		//设置地址
		List<Address> addressList=(List<Address>) session.getAttribute("addressList");
		Address address=addressList.get(0);
		
		OrderInfoService ois=new OrderInfoServiceImpl();
		ois.addOrderInfo(orderInfo, address, carGoodsList);
		
		req.setAttribute("orderInfo", orderInfo);
		req.getRequestDispatcher("/front/orderPay.jsp").forward(req, resp);
//		resp.sendRedirect(req.getContextPath()+"/front/carlist.jsp");
		
	
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}
	
	
	private AddressService as=new AddressServiceImpl();
	protected void settlementCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");
		AddressService as=new AddressServiceImpl();
		List<Address> addressList=null;
		
		addressList=as.findAddressByUid(user.getAdmin_Id());

		String[] goodsIds=req.getParameterValues("checkid");
		
		List<CarGoods> carGoodsList=new ArrayList<CarGoods>();//已确定购买的商品list
		HashMap<Integer,CarGoods> goodsCarMap=(HashMap<Integer, CarGoods>) session.getAttribute("goodsCarMap");//购物车商品列表
		
		if(goodsIds!=null){
			for(String goodsId: goodsIds){
				
				CarGoods carGoods2=goodsCarMap.get(Integer.parseInt(goodsId.trim()));
				carGoodsList.add(carGoods2);
			}
		}
		
		HttpSession session2=req.getSession();
		session2.setAttribute("carGoodsList", carGoodsList);
		
		req.setAttribute("carGoodsList", carGoodsList);
		req.setAttribute("addressList", addressList);
		
		req.getRequestDispatcher("front/order.jsp").forward(req, resp);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}

	
	private GoodsService gs=new GoodsServiceImpl();
	protected void addGoodsToCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try{
		HttpSession session=req.getSession();
		
		HashMap<Integer, CarGoods> goodsCarMap=null;
		
		if(session.getAttribute("goodsCarMap")!=null){
			goodsCarMap=(HashMap<Integer, CarGoods>) session.getAttribute("goodsCarMap");
		}else {
			goodsCarMap= new HashMap<Integer,CarGoods>();
		}
		
		String goodsId=req.getParameter("id");
		Goods goods=gs.findGoodsById(Integer.parseInt(goodsId));
		
		if(goodsCarMap.containsKey(goods.getGoods_Id())){
			CarGoods carGoods= goodsCarMap.get(goods.getGoods_Id());
			carGoods.setNum(carGoods.getNum()+1);
		}else{
			CarGoods carGoods=new CarGoods();
			carGoods.setNum(1);
			carGoods.setGoods(goods);
			goodsCarMap.put(goods.getGoods_Id(), carGoods);
		}
		
		session.setAttribute("goodsCarMap", goodsCarMap);
		resp.sendRedirect("front/carlist.jsp");
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}

}
