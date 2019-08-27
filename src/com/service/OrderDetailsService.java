package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.OrderDetails;

public interface OrderDetailsService {
	public int addOrderDatils(OrderDetails orderDetails ) throws SQLException;
	
	public List<OrderDetails> getAllDetails() throws SQLException;
	
	public int findPageCount(Integer pageSize) throws SQLException;
	
	public List<OrderDetails> getPageDetails(Integer page,Integer pageSize) throws SQLException;

}
