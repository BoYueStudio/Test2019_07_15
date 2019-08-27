package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ParamSupport;

import com.bean.User;
import com.dao.UserDao;
import com.utils.MyCon;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByName(String name) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from admins where login_Name=?";
		PreparedStatement prst= con.prepareStatement(sql);
		prst.setString(1, name);
		ResultSet res=prst.executeQuery();
		User user=null;
		while(res.next()){
			Integer admin_Id=res.getInt("admin_Id");
			String login_Name=res.getString("login_Name");
			String pet_Name=res.getString("pet_Name");
			String pass=res.getString("pass");
			Integer role=res.getInt("role");
			Integer statu=res.getInt("statu");
			String reg_Date=res.getString("reg_Date");
			user=new User(admin_Id, login_Name, pet_Name, pass, role, statu, reg_Date);
		}
		return user;
		
		
	}
	



	@Override
	public boolean addUser(User user) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="insert into admins(login_Name,pet_Name,pass,role,statu,reg_Date) values(?,?,?,?,?,?)";
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setString(1, user.getLogin_Name());
			prst.setString(2, user.getPet_Name());
			prst.setString(3, user.getPass());
			prst.setInt(4, user.getRole());
			prst.setInt(5, user.getStatu());
			prst.setString(6, user.getReg_Date());
			
			return prst.executeUpdate()>0;
		
		

	}

	@Override
	public boolean updateUserById(User user) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="update admins set pass=? where admin_Id=?";
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setString(1, user.getPass());
			prst.setInt(2, user.getAdmin_Id());
			
			return prst.executeUpdate()>0;

	}




	@Override
	public List<User> getAllUser() throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from admins";
			PreparedStatement prst=con.prepareStatement(sql);
			ResultSet rs= prst.executeQuery();
			List<User> list=new ArrayList<>();
			while(rs.next()){
				Integer admin_Id=rs.getInt("admin_Id");
				String login_Name=rs.getString("login_Name");
				String pet_Name=rs.getString("pet_Name");
				String pass=rs.getString("pass");
				Integer role=rs.getInt("role");
				Integer statu=rs.getInt("statu");
				String reg_Date=rs.getString("reg_Date");
				User user =new User(admin_Id, login_Name, pet_Name, pass, role, statu, reg_Date);
				list.add(user);
			}
		
		return list;
	}



	/**
	 * findUserPageCount（）查找user表的页数方法
	 * rowcount总条数
	 * pageSize每页的条数
	 * 根据条数计算总的页数
	 * pageCount
	 *
	 */
	@Override
	public Integer findUserPageCount(Integer pageSize) throws SQLException {
		Connection con = new MyCon().getCon();
		String sql = "select count(1) rowcount from admins";
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
	public List<User> getUserByPage(Integer page,Integer pageSize) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from admins limit ?,?";
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, (page-1)*pageSize);
			prst.setInt(2, pageSize);
			ResultSet rs= prst.executeQuery();
			List<User> list=new ArrayList<>();
			while(rs.next()){
				Integer admin_Id=rs.getInt("admin_Id");
				String login_Name=rs.getString("login_Name");
				String pet_Name=rs.getString("pet_Name");
				String pass=rs.getString("pass");
				Integer role=rs.getInt("role");
				Integer statu=rs.getInt("statu");
				String reg_Date=rs.getString("reg_Date");
				User user =new User(admin_Id, login_Name, pet_Name, pass, role, statu, reg_Date);
				list.add(user);
			}
		
		return list;
	}



}
