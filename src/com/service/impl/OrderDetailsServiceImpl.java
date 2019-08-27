package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bean.OrderDetails;
import com.dao.OrderDatilsDao;
import com.dao.impl.OrderDatilsDaoImpl;
import com.service.OrderDetailsService;

public class OrderDetailsServiceImpl implements OrderDetailsService {

	
	OrderDatilsDao od=new OrderDatilsDaoImpl();
	@Override
	public int addOrderDatils(OrderDetails orderDetails) throws SQLException {
		// TODO Auto-generated method stub
		return od.addOrderDatils(orderDetails);
	}
	@Override
	public List<OrderDetails> getAllDetails() throws SQLException {
		// TODO Auto-generated method stub
		return od.getAllDetails();
	}
	@Override
	public int findPageCount(Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return od.findPageCount(pageSize);
	}
	@Override
	public List<OrderDetails> getPageDetails(Integer page, Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return od.getPageDetails(page, pageSize);
	}

	
}
