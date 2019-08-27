package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Goods;

public interface GoodsService  {
	public List<Goods> getAllGoods() throws Exception;
	public Integer fintGoodsPageCount(Integer pageSize) throws SQLException;//查找goods总条数
	public List<Goods> getGoodsPage(Integer onPage,Integer pageSize)throws SQLException;//根据当前页和每页条数limit ？ ？
	public Boolean insertGoods(Goods goods) throws SQLException;
	public Boolean deleteGoodsById(Integer id) throws SQLException;
	public Boolean updateGoods(Goods goods) throws SQLException;
	public Goods findGoodsById(Integer id) throws SQLException;
}
