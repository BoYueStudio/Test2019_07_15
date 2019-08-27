package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.Address;

public interface AddressDao {
 public List<Address> findAddressByUid(Integer id) throws SQLException;
 public Boolean insertAddress(Address address) throws SQLException;
 public Address getAddressByAid(Integer id) throws  SQLException;

}
