package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.User;

public interface UserDao {
public User findUserByName(String name) throws SQLException;
public boolean addUser(User user)  throws SQLException;
public boolean updateUserById(User user) throws SQLException ;

public List<User> getAllUser() throws SQLException;
public Integer findUserPageCount(Integer pageSize) throws SQLException;//根据每页条数查找总页数
public List<User> getUserByPage(Integer page,Integer pageSize) throws SQLException;//根据页数获取User的集合

}
