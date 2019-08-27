package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bean.Address;
import com.dao.AddressDao;
import com.dao.impl.AddressDaoImpl;
import com.service.AddressService;

public class AddressServiceImpl implements AddressService {
	
	AddressDao ad=new AddressDaoImpl();
	@Override
	public List<Address> findAddressByUid(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return ad.findAddressByUid(id);
	}
	@Override
	public Boolean insertAddress(Address address) throws SQLException {
		// TODO Auto-generated method stub
		return ad.insertAddress(address);
	}
	@Override
	public Address getAddressByAid(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return ad.getAddressByAid(id);
	}

}
