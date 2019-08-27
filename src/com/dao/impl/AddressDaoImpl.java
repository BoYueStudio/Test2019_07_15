package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Address;
import com.bean.Goods;
import com.bean.GoodsType;
import com.dao.AddressDao;
import com.utils.MyCon;

public class AddressDaoImpl implements AddressDao {

	@Override
	public List<Address> findAddressByUid(Integer id) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from adress where admins_Id = ?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, id);
		ResultSet rs= prst.executeQuery();
		List<Address> list=new ArrayList<Address>();
		while(rs.next()){
			Integer address_Id=rs.getInt("address_Id");
			Integer admins_Id=rs.getInt("admins_Id");
			String address=rs.getString("address");
			String dress_Name=rs.getString("address_Name");
			String address_Phone=rs.getString("address_Phone");
			Address ar=new Address(address_Id, admins_Id, address, dress_Name, address_Phone);
		
			list.add(ar);
		}

		return list;
		
	}

	@Override
	public Boolean insertAddress(Address address) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="insert into adress ( admins_Id,address,address_Name,address_Phone) values(?,?,?,?)";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, address.getAdmins_Id());
		prst.setString(2, address.getAddress());
		prst.setString(3, address.getDress_Name());
		prst.setString(4, address.getAddress_Phone());
		
		return prst.executeUpdate()>0;
		
		


	}

	@Override
	public Address getAddressByAid(Integer id) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from adress where address_Id=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, id);
		ResultSet rs=prst.executeQuery();
		Address ar=null;
		while(rs.next()){
			Integer address_Id=rs.getInt("address_Id");
			Integer admins_Id=rs.getInt("admins_Id");
			String address=rs.getString("address");
			String dress_Name=rs.getString("address_Name");
			String address_Phone=rs.getString("address_Phone");
			ar=new Address(address_Id, admins_Id, address, dress_Name, address_Phone);
		
			
			
		}
		
		
		return ar;
	}

}
