package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bean.Goods;
import com.dao.GoodsDao;
import com.dao.impl.GoodsDaoImpl;
import com.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	
	GoodsDao gs=new GoodsDaoImpl();
	@Override
	public List<Goods> getAllGoods() throws Exception {
		// TODO Auto-generated method stub
		return gs.getAllGoods();
	}
	@Override
	public Boolean insertGoods(Goods goods) throws SQLException {
		// TODO Auto-generated method stub
		return gs.insertGoods(goods);
	}

	@Override
	public Boolean deleteGoodsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return gs.deleteGoodsById(id);
	}
	@Override
	public Boolean updateGoods(Goods goods) throws SQLException {
		// TODO Auto-generated method stub
		return gs.updateGoods(goods);
	}
	@Override
	public Goods findGoodsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return gs.findGoodsById(id);
	}
//
	@Override
	public Integer fintGoodsPageCount(Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return gs.fintGoodsPageCount(pageSize);
	}
	@Override
	public List<Goods> getGoodsPage(Integer onPage, Integer pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return gs.getGoodsPage(onPage, pageSize);
	}
}
