package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.Goods;

public interface GoodsDao {
public List<Goods> getAllGoods() throws SQLException;
public Integer fintGoodsPageCount(Integer pageSize) throws SQLException;//����goods������
public List<Goods> getGoodsPage(Integer onPage,Integer pageSize)throws SQLException;//���ݵ�ǰҳ��ÿҳ����limit �� ��
public Boolean insertGoods(Goods goods) throws SQLException;
public Boolean deleteGoodsById(Integer id) throws SQLException;
public Boolean updateGoods(Goods goods) throws SQLException;
public Goods findGoodsById(Integer id) throws SQLException;


}
