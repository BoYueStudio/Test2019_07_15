package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.GoodsType;

public interface GoodsTypeService {
	public List<GoodsType> getAllGoodsType() throws SQLException;
	public GoodsType findGoodsTypeById(Integer id) throws SQLException;

}
