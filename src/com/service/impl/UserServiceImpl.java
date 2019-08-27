package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userdao=new UserDaoImpl();

	@Override
	public User findUserByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.findUserByName(name);
	}

	@Override
	public Boolean addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public Boolean updateUserById(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.updateUserById(user);
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return userdao.getAllUser();
	}

	@Override
	public Integer findUserPageCount(Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.findUserPageCount(pageSize);
	}

	@Override
	public List<User> getUserByPage(Integer page,Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.getUserByPage(page,pageSize);
	}

	

}
