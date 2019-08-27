package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Address;

public interface AddressService {
	 public List<Address> findAddressByUid(Integer id) throws SQLException;
	 public Boolean insertAddress(Address address) throws SQLException;
	 public Address getAddressByAid(Integer id) throws  SQLException;
	 
}
