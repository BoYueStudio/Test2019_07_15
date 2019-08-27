package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Address;
import com.bean.CarGoods;
import com.bean.OrderInfo;

public interface OrderInfoService {
	public int addOrderInfo(OrderInfo orderInfo) throws SQLException;
	
	public void addOrderInfo(OrderInfo order,Address address,List<CarGoods> carGoodsList) throws Exception;
	
	public List<OrderInfo> getAllOrder() throws SQLException;
	
	public int findPageCount(Integer pageSize) throws  SQLException;
	
	public List<OrderInfo> getPageOrder(Integer onPage, Integer pageSize) throws SQLException;

	public List<Object[]> getSaleByMoth() throws SQLException ;
	
	public OrderInfo getOrderInfoById(String id) throws Exception;
}
