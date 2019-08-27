package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.User;
import com.utils.MyCon;

public interface UserService {
	public User findUserByName(String name) throws SQLException;
 public Boolean addUser(User user)  throws SQLException;
 public Boolean updateUserById(User user) throws SQLException;
 public List<User> getAllUser() throws SQLException;
 
 public Integer findUserPageCount(Integer pageSize) throws SQLException;
 public List<User> getUserByPage(Integer page,Integer pageSize) throws SQLException;//根据页数获取User的集合

}
