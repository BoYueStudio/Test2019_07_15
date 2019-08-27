package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Goods;
import com.bean.User;
import com.dao.GoodsDao;
import com.mysql.cj.protocol.Resultset;
import com.utils.MyCon;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public List<Goods> getAllGoods() throws SQLException{
		Connection con=new MyCon().getCon();
		String sql="select *from goods";
		PreparedStatement prst=con.prepareStatement(sql);
		ResultSet rs= prst.executeQuery();
		List<Goods> list=new ArrayList<Goods>();
		while(rs.next()){
			Goods g=new Goods();
			g.setGoods_Id(rs.getInt("goods_Id"));
			g.setGoods_Name(rs.getString("goods_Name"));
			g.setGoods_Num(rs.getInt("goods_Num"));
			g.setGoods_Pic(rs.getString("goods_Pic"));
			g.setGoods_Price(rs.getDouble("goods_Price"));
			g.setGoods_Type(rs.getInt("goods_Type"));
			g.setStatu(rs.getInt("statu"));
			g.setDesc(rs.getString("goods_Desc"));
			g.setDate(rs.getString("date"));
			list.add(g);	
		}

		return list;
	}

	@Override
	public Boolean insertGoods(Goods goods) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="insert into goods(goods_Name,goods_Num,goods_Price,goods_Pic,goods_Type,goods_desc,statu,date) values(?,?,?,?,?,?,?,?)";
		PreparedStatement prst=con.prepareStatement(sql);
//		prst.setInt(1, goods.getGoodsid());
		prst.setString(1, goods.getGoods_Name());
		prst.setInt(2, goods.getGoods_Num());
		prst.setDouble(3, goods.getGoods_Price());
		prst.setString(4, goods.getGoods_Pic());
		prst.setInt(5, goods.getGoods_Type());
		prst.setString(6, goods.getDesc());
		prst.setInt(7, goods.getStatu());
		prst.setString(8, goods.getDate());
		
		return prst.executeUpdate()>0;
			
	}


	@Override
	public Boolean deleteGoodsById(Integer id) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="delete from goods where goods_Id=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, id);
		return prst.executeUpdate()>0;
	}

	@Override
	public Boolean updateGoods(Goods goods) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="update goods set goods_Name=?,goods_Num=?,goods_Price=?,goods_Type=?,goods_Pic=?,goods_Desc=?,statu=?,date=? where goods_Id=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setString(1, goods.getGoods_Name());
		prst.setInt(2, goods.getGoods_Num());
		prst.setDouble(3, goods.getGoods_Price());
		prst.setInt(4, goods.getGoods_Type());
		prst.setString(5, goods.getGoods_Pic());
		prst.setString(6, goods.getDesc());
		prst.setInt(7, goods.getStatu());
		prst.setString(8, goods.getDate());
		prst.setInt(9, goods.getGoods_Id());
		return prst.executeUpdate()>0;
	}

	@Override
	public Goods findGoodsById(Integer id) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from goods where goods_Id=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, id);
		ResultSet rs=prst.executeQuery();
		Goods goods=new Goods();
		while(rs.next()){
		
			goods.setGoods_Id(rs.getInt("goods_Id"));
			goods.setGoods_Name(rs.getString("goods_Name"));
			goods.setGoods_Num(rs.getInt("goods_Num"));
			goods.setGoods_Price(rs.getDouble("goods_Price"));
			goods.setGoods_Type(rs.getInt("goods_Type"));
			goods.setGoods_Pic(rs.getString("goods_Pic"));
			goods.setDesc(rs.getString("goods_Desc"));
			goods.setStatu(rs.getInt("statu"));
			goods.setDate(rs.getString("date"));
			
		}
		return goods;

	}

	@Override
	public Integer fintGoodsPageCount(Integer pageSize) throws SQLException {

		Connection con = new MyCon().getCon();
		String sql = "select count(1) rowcount from goods";
		PreparedStatement prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		int rowCount=0;
		while(rs.next()){
			rowCount=rs.getInt("rowcount");
		}
		int pageCount=0;
		pageCount=rowCount%pageSize==0 ? rowCount/pageSize : rowCount/pageSize+1;		
		
		return pageCount;
	}

	@Override
	public List<Goods> getGoodsPage(Integer page,Integer pageSize) throws SQLException {
		Connection con=new MyCon().getCon();
		String sql="select *from goods limit ?,?";
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, (page-1)*pageSize);
			prst.setInt(2, pageSize);
			ResultSet rs= prst.executeQuery();
			List<Goods> list=new ArrayList<>();
			while(rs.next()){
				Goods g=new Goods();
				g.setGoods_Id(rs.getInt("goods_Id"));
				g.setGoods_Name(rs.getString("goods_Name"));
				g.setGoods_Num(rs.getInt("goods_Num"));
				g.setGoods_Pic(rs.getString("goods_Pic"));
				g.setGoods_Price(rs.getDouble("goods_Price"));
				g.setGoods_Type(rs.getInt("goods_Type"));
				g.setStatu(rs.getInt("statu"));
				g.setDesc(rs.getString("goods_Desc"));
				g.setDate(rs.getString("date"));
				list.add(g);
			}
		
		return list;
	}

}
