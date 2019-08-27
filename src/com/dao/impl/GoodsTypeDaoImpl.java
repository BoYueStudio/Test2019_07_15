package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Goods;
import com.bean.GoodsType;
import com.dao.GoodsTypeDao;
import com.utils.MyCon;



public class GoodsTypeDaoImpl implements GoodsTypeDao{

	@Override
	public List<GoodsType> getAllGoodsType() throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from goods_type";
		PreparedStatement prst=con.prepareStatement(sql);
		ResultSet rs= prst.executeQuery();
		List<GoodsType> list=new ArrayList<GoodsType>();

		while(rs.next()){
			GoodsType gt=new GoodsType();
			gt.setType_Id(rs.getInt("type_Id"));
			gt.setType_Name(rs.getString("type_Name"));
			gt.setType_Pid(rs.getInt("type_Pid"));
			gt.setType_Path(rs.getString("type_Path"));
			gt.setType_Lv(rs.getInt("type_Lv"));
			gt.setStatu(rs.getInt("statu"));
			list.add(gt);
		}
		return list;
	}

	@Override
	public GoodsType findGoodsTypeById(Integer id) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from goods_type where type_Id=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, id);
		ResultSet rs=prst.executeQuery();
		GoodsType gt=new GoodsType();
		


		while(rs.next()){
			gt.setType_Id(id);
			gt.setType_Name(rs.getString("type_Name"));
			gt.setType_Pid(rs.getInt("type_Pid"));
			gt.setType_Path(rs.getString("type_Path"));
			gt.setType_Lv(rs.getInt("type_Lv"));
			gt.setStatu(rs.getInt("statu"));
			
		}
		return gt;
	}

}
