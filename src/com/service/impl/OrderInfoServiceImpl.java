package com.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bean.Address;
import com.bean.CarGoods;
import com.bean.OrderDetails;
import com.bean.OrderInfo;
import com.dao.OrderDatilsDao;
import com.dao.OrderInfoDao;
import com.dao.impl.OrderDatilsDaoImpl;
import com.dao.impl.OrderInfoDaoImpl;
import com.service.OrderDetailsService;
import com.service.OrderInfoService;
import com.utils.IDUtils;
import com.utils.MyCon;

public class OrderInfoServiceImpl implements OrderInfoService {

	private OrderInfoDao orderInfoDao=new OrderInfoDaoImpl();
	private OrderDatilsDao detailsDao=new OrderDatilsDaoImpl();  
	@Override
	public int addOrderInfo(OrderInfo orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.addOrderInfo(orderInfo);
	}
	@Override
	public void addOrderInfo(OrderInfo order, Address address, List<CarGoods> carGoodsList) throws Exception {
		Connection con=null;
		try{
			con= new MyCon().getCon();
			con.setAutoCommit(false);
		//Ìí¼Ó¶©µ¥	
		order.setAddress(address.getAddress());
		order.setUname(address.getDress_Name());
		order.setPhone(address.getAddress_Phone());
		order.setO_date(new Date().toLocaleString());
		order.setO_id(IDUtils.getId());
		
		
		orderInfoDao.addOrderInfo(order);
			for(CarGoods c:carGoodsList){
				//¶©µ¥ÏêÏ¸
				OrderDetails details=new OrderDetails();
				details.setO_id(order.getO_id());
				details.setG_id(c.getGoods().getGoods_Id());
				details.setTotal(c.getNum());
				details.setO_date(new Date().toLocaleString());
				detailsDao.addOrderDatils(details);
				
			}
			
			
			con.commit();
			
		}catch (Exception e) {
			con.rollback();
			throw new Exception(e);
		}finally {
			con.close();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	public List<OrderInfo> getAllOrder() throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getAllOrder();
	}
	@Override
	public int findPageCount(Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.findPageCount(pageSize);
	}
	@Override
	public List<OrderInfo> getPageOrder(Integer onPage, Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getPageOrder(onPage, pageSize);
	}
	@Override
	public List<Object[]> getSaleByMoth() throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getSaleByMoth();
	}
	@Override
	public OrderInfo getOrderInfoById(String id) throws Exception {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderInfoById(id);
	}

}
