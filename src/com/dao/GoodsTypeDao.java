package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.GoodsType;

public interface GoodsTypeDao {
	
	public List<GoodsType> getAllGoodsType() throws SQLException;
	public GoodsType findGoodsTypeById(Integer id) throws SQLException;

}
