package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bean.Goods;
import com.bean.OrderInfo;
import com.bean.User;
import com.dao.OrderInfoDao;
import com.mysql.cj.protocol.Resultset;
import com.service.impl.OrderInfoServiceImpl;
import com.utils.MyCon;

public class OrderInfoDaoImpl implements OrderInfoDao {



	
	@Override
	public int addOrderInfo(OrderInfo orderInfo) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="insert into order_info ( o_id,u_id,total,address,phone,uname,beizhu,statu,o_date) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setString(1, orderInfo.getO_id());
		prst.setInt(2, orderInfo.getU_id());
		prst.setDouble(3, orderInfo.getTotal());
		prst.setString(4, orderInfo.getAddress());
		prst.setString(5, orderInfo.getPhone());
		prst.setString(6, orderInfo.getUname());
		prst.setString(7, orderInfo.getBeizhu());
		prst.setString(8, orderInfo.getStatu());
		prst.setString(9, orderInfo.getO_date());
		return prst.executeUpdate();
	}

	@Override
	public List<OrderInfo> getAllOrder() throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from order_info ";
		PreparedStatement prst=con.prepareStatement(sql);
		ResultSet rs= prst.executeQuery();
		List<OrderInfo> orderList=new ArrayList<OrderInfo>();
		
		while(rs.next()){
			String o_id=rs.getString("o_id");
			Integer u_id=rs.getInt("u_id");
			Double total=rs.getDouble("total");
			String address=rs.getString("address");
			String phone=rs.getString("phone");
			String uname=rs.getString("uname");
			String beizhu=rs.getString("beizhu");
			String statu=rs.getString("statu");
			String o_date=rs.getString("o_date");
			OrderInfo order=new OrderInfo(o_id, u_id, total, address, phone, uname, beizhu, statu, o_date);
			orderList.add(order);
		
		}
		
		
		return orderList;
	}

	@Override
	public int findPageCount(Integer pageSize) throws SQLException {
		Connection con = new MyCon().getCon();
		String sql = "select count(1) rowcount from order_info";
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
	public List<OrderInfo> getPageOrder(Integer page, Integer pageSize) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from order_info limit ?,?";
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, (page-1)*pageSize);
			prst.setInt(2, pageSize);
			ResultSet rs= prst.executeQuery();
			List<OrderInfo> orderList=new ArrayList<OrderInfo>();
			
			while(rs.next()){
				String o_id=rs.getString("o_id");
				Integer u_id=rs.getInt("u_id");
				Double total=rs.getDouble("total");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				String uname=rs.getString("uname");
				String beizhu=rs.getString("beizhu");
				String statu=rs.getString("statu");
				String o_date=rs.getString("o_date");
				OrderInfo order=new OrderInfo(o_id, u_id, total, address, phone, uname, beizhu, statu, o_date);
				orderList.add(order);
			
			}
			
			
			return orderList;
	}

	@Override
	public List<Object[]> getSaleByMoth() throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select YEAR(o_date) year,MONTH(o_date) month,sum(total) totalPrice from order_info GROUP BY MONTH(o_date),YEAR(o_date);";
			PreparedStatement prst=con.prepareStatement(sql);
			
			ResultSet rs= prst.executeQuery();
			List<Object[]> saleList=new ArrayList<Object[]>();
			
			while(rs.next()){
				Object[] obj=new Object[3];
				obj[0]=rs.getString("year");
				obj[1]=rs.getString("month");
				obj[2]=rs.getString("totalPrice");
				
				saleList.add(obj);
			
			}
			
			
			return saleList;
	}

	@Override
	public OrderInfo getOrderInfoById(String id) throws Exception {
		Connection con=new MyCon().getCon();
		String sql="select *from order_info where o_id=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setString(1, id);
		ResultSet rs=prst.executeQuery();
		OrderInfo orderInfo=new OrderInfo();
		while(rs.next()){
		
			orderInfo.setO_id(id);
			orderInfo.setU_id(rs.getInt("u_id"));
			orderInfo.setTotal(rs.getDouble("total"));
			orderInfo.setAddress(rs.getString("address"));
			orderInfo.setPhone(rs.getString("phone"));
			orderInfo.setUname(rs.getString("uname"));
			orderInfo.setBeizhu(rs.getString("beizhu"));
			orderInfo.setStatu(rs.getString("statu"));
			//orderInfo.setO_date(rs.getString("o_date"));
			
			
		}
		return orderInfo;
	}
	

}
