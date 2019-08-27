package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.OrderInfo;

public interface OrderInfoDao {
	public int addOrderInfo(OrderInfo orderInfo) throws SQLException;

	public List<OrderInfo> getAllOrder() throws SQLException;

	public int findPageCount(Integer pageSize) throws SQLException;

	public List<OrderInfo> getPageOrder(Integer onPage, Integer pageSize) throws SQLException;

	public List<Object[]> getSaleByMoth() throws SQLException;

	public OrderInfo getOrderInfoById(String id) throws Exception;
}
