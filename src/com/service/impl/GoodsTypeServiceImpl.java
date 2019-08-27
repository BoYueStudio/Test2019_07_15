package com.service.impl;


import java.sql.SQLException;
import java.util.List;

import com.bean.GoodsType;
import com.dao.GoodsTypeDao;
import com.dao.impl.GoodsTypeDaoImpl;
import com.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService {
	
	GoodsTypeDao gt=new GoodsTypeDaoImpl();
	@Override
	public List<GoodsType> getAllGoodsType() throws SQLException {
		// TODO Auto-generated method stub
		return gt.getAllGoodsType();
	}
	@Override
	public GoodsType findGoodsTypeById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return gt.findGoodsTypeById(id);
	}

}
