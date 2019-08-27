package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.OrderDetails;
import com.bean.OrderInfo;
import com.dao.OrderDatilsDao;
import com.dao.OrderInfoDao;
import com.utils.MyCon;

public class OrderDatilsDaoImpl implements OrderDatilsDao {


	@Override
	public int addOrderDatils(OrderDetails orderDetails) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="insert into order_details ( o_id,g_id,total,o_date) values(?,?,?,?)";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setString(1,orderDetails.getO_id());
		prst.setInt(2, orderDetails.getG_id());
		prst.setDouble(3, orderDetails.getTotal());
		prst.setString(4, orderDetails.getO_date());
		return prst.executeUpdate();
	}

	@Override
	public List<OrderDetails> getAllDetails() throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from  order_details";
		PreparedStatement prst=con.prepareStatement(sql);
		ResultSet rs= prst.executeQuery();
		List<OrderDetails> detailsList=new ArrayList<OrderDetails>();
		while(rs.next()){
			OrderDetails details=new OrderDetails();
			details.setO_id(rs.getString("o_id"));
			details.setG_id(rs.getInt("g_id"));
			details.setTotal(rs.getInt("total"));
			details.setO_date(rs.getString("o_date"));
			detailsList.add(details);
		}
		
		
		
		return detailsList;
	}

	@Override
	public int findPageCount(Integer pageSize) throws SQLException {
		Connection con = new MyCon().getCon();
		String sql = "select count(1) rowcount from order_details";
		PreparedStatement prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		int rowCount=0;
		while(rs.next()){
			rowCount=rs.getInt("rowcount");
		}
		int pageCount=0;
		pageCount=rowCount%pageSize==0 ? rowCount/pageSize : rowCount/pageSize+1;		
		
		return pageCount;
	}

	@Override
	public List<OrderDetails> getPageDetails(Integer page,Integer pageSize) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from order_details limit ?,?";
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, (page-1)*pageSize);
			prst.setInt(2, pageSize);
			ResultSet rs= prst.executeQuery();
			List<OrderDetails> detailsList=new ArrayList<OrderDetails>();
			while(rs.next()){
				OrderDetails details=new OrderDetails();
				details.setOd_id(rs.getInt("od_id"));
				details.setO_id(rs.getString("o_id"));
				details.setG_id(rs.getInt("g_id"));
				details.setTotal(rs.getInt("total"));
				details.setO_date(rs.getString("o_date"));
				detailsList.add(details);
			}
			
			
			
			return detailsList;	}

}
